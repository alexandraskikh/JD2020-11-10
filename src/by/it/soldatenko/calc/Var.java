package by.it.soldatenko.calc;

import java.util.*;

abstract class Var implements Operation {
    private static final Map<String, Var> variables = new HashMap<>();

    public static Var save(String varName, Var varValue){
        variables.put(varName,varValue);
        return varValue;
    }

    public static void printVar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
    public static void sortVar() {
        TreeMap<String, Var> sorted = new TreeMap<>(variables);
        for (Map.Entry<String, Var> entry : sorted.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }


    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        }
        else{if(variables.containsKey(operand)){
            return variables.get(operand);
            }
        }

        throw new CalcException("Var "+ operand+"not found");

    }


    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }

    @Override
    public String toString() {
        return "some abstract Var{}";
    }
}
