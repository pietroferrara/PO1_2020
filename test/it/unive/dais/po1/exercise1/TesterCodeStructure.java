package it.unive.dais.po1.exercise1;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TesterCodeStructure {

    @Test
    public void testPlayerStructure() {
        Class<Player> c = Player.class;

        Map<String, String> fieldsExpected;
        Map<String, String[]> methodsPars;
        Map<String, String> methodsReturnTypes;


        fieldsExpected = new HashMap<>();
        fieldsExpected.put("mark", "it.unive.dais.po1.exercise1.Mark");
        methodsPars = new HashMap<>();
        methodsPars.put("play", new String[]{"it.unive.dais.po1.exercise1.TicTacToeBoard"});
        methodsReturnTypes = new HashMap<>();
        methodsReturnTypes.put("play", "boolean");

        InnerTester test = new InnerTester(fieldsExpected, methodsPars, methodsReturnTypes, c, System.out);

        Assert.assertTrue(test.checkFoundFields());
        Assert.assertTrue(test.checkFoundMethods());
        Assert.assertTrue(test.checkExpectedFields());
        Assert.assertTrue(test.checkExpectedMethods());
    }


    @Test
    public void testTicTacToeBoard() {
        Class<TicTacToeBoard> c = TicTacToeBoard.class;

        Map<String, String> fieldsExpected;
        Map<String, String[]> methodsPars;
        Map<String, String> methodsReturnTypes;


        fieldsExpected = new HashMap<>();
        fieldsExpected.put("board", "[[Lit.unive.dais.po1.exercise1.Mark;");
        methodsPars = new HashMap<>();
        methodsReturnTypes = new HashMap<>();

        methodsPars.put("isFull", new String[]{});
        methodsReturnTypes.put("isFull", "boolean");

        methodsPars.put("winner", new String[]{});
        methodsReturnTypes.put("winner", "it.unive.dais.po1.exercise1.Mark");

        methodsPars.put("getMark", new String[]{"int", "int"});
        methodsReturnTypes.put("getMark", "it.unive.dais.po1.exercise1.Mark");

        methodsPars.put("put", new String[]{"it.unive.dais.po1.exercise1.Mark", "int", "int"});
        methodsReturnTypes.put("put", "boolean");

        InnerTester test = new InnerTester(fieldsExpected, methodsPars, methodsReturnTypes, c, System.out);

        Assert.assertTrue(test.checkFoundFields());
        Assert.assertTrue(test.checkFoundMethods());
        Assert.assertTrue(test.checkExpectedFields());
        Assert.assertTrue(test.checkExpectedMethods());
    }

    private static class InnerTester {


        private final Map<String, String> expectedFields;
        private final Map<String, String[]> expectedMethodsPars;
        private final Map<String, String> expectedMethodsReturnTypes;
        private final Class<?> foundClass;
        private final Field[] foundFields;
        private final Method[] foundMethods;
        private final PrintStream printer;

        public InnerTester(Map<String, String> expectedFields, Map<String, String[]> expectedMethodsPars, Map<String, String> expectedMethodsReturnTypes, Class<?> foundClass, PrintStream printer) {
            this.expectedFields = expectedFields;
            this.expectedMethodsPars = expectedMethodsPars;
            this.expectedMethodsReturnTypes = expectedMethodsReturnTypes;
            this.foundClass = foundClass;
            this.foundFields = foundClass.getDeclaredFields();
            this.foundMethods = foundClass.getDeclaredMethods();
            this.printer = printer;
        }

        private boolean isMethodContained(String methodName) {
            for(Method m : foundMethods)
                if(m.getName().equals(methodName))
                    return true;
            return false;
        }

        private boolean isFieldContained(String fieldName) {
            for(Field f : foundFields)
                if(f.getName().equals(fieldName))
                    return true;
            return false;
        }

        private boolean isPrivate(Member f) {
            int modifiers = f.getModifiers();
            return Modifier.isPrivate(modifiers);
        }

        private boolean isPublic(Member f) {
            int modifiers = f.getModifiers();
            return Modifier.isPublic(modifiers);
        }
        private boolean isFieldNameExpected(Field f) {
            return expectedFields.containsKey(f.getName());
        }
        private boolean isFieldTypeCorrect(Field f) {
            return expectedFields.get(f.getName()).equals(f.getType().getName());
        }
        private boolean isMethodReturnTypeExpected(Method f) {
            return expectedMethodsReturnTypes.get(f.getName()).equals(f.getReturnType().getName());
        }
        private boolean isMethodNameExpected(Method f) {
            return expectedMethodsPars.containsKey(f.getName());
        }

        private boolean checkMethodParameterListCorrect(Method m, PrintStream printer) {
            boolean successful = true;
            Parameter[] pars = m.getParameters();
            String[] expected = expectedMethodsPars.get(m.getName());
            if(pars.length!=expected.length) {
                printer.println("Expecting "+expected.length+" parameters for method "+m.getName()+", found "+pars.length);
                successful = false;
            }
            Collection<String> coll = Arrays.asList(expected);
            for(Parameter p : pars)
                if(! coll.contains(p.getType().getName())) {
                    printer.println("Type "+p.getType()+" of parameter "+p.getName()+" not expected");
                    successful = false;
                }

            return successful;
        }

        public boolean checkFoundFields() {
            boolean successful = true;
            for(Field f : foundFields) {
                if(! f.getDeclaringClass().equals(foundClass)) continue;
                if(! this.isPrivate(f)) {
                    printer.println("Field "+f.getName()+" is not private");
                    successful = false;
                }
                if(! this.isFieldNameExpected(f)) {
                    printer.println("Field "+f.getName()+" should not be present");
                    successful = false;
                }
                else  if(! this.isFieldTypeCorrect(f)) {
                    printer.println("Field " + f.getName() + " should be of type " + f.getType().getName());
                    successful = false;
                }
            }
            return successful;
        }

        public boolean checkFoundMethods() {
            boolean successful = true;
            for(Method m : foundMethods) {
                if(! m.getDeclaringClass().equals(foundClass)) continue;
                if(this.isPrivate(m)) continue;
                if(! this.isPublic(m)) {
                    printer.println("Method "+m.getName()+" is neither public nor private");
                    successful = false;
                }
                if(! this.isMethodNameExpected(m)) {
                    printer.println("Method "+m.getName()+" that is not private should not be present");
                    successful = false;
                }
                else {
                    if(! this.checkMethodParameterListCorrect(m, printer))
                        successful = false;
                    if(! this.isMethodReturnTypeExpected(m)) {
                        printer.println("Return type of method "+m.getName()+" is "+m.getReturnType().getName()+" instead of "+expectedMethodsReturnTypes.get(m.getName()));
                        successful = false;
                    }
                }
            }
            return successful;
        }

        public boolean checkExpectedFields() {
            boolean successful = true;
            for(String fieldName : expectedFields.keySet())
                if(! this.isFieldContained(fieldName)) {
                    printer.println("Field " + fieldName + " not found");
                    successful = false;
                }
            return successful;
        }

        public boolean checkExpectedMethods() {
            boolean successful = true;
            for(String methodName : expectedMethodsPars.keySet())
                if(! this.isMethodContained(methodName)) {
                    printer.println("Method "+methodName+" not found");
                    successful = false;
                }
            return successful;
        }
    }
}
