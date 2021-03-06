package by.it.plehanova.calc;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException{
        expression = expression.trim().replaceAll("\\s+", "");
        String[] line = expression.split(Patterns.OPERATION);

        if (line.length < 2) {
            return Var.createVar(expression);
        }
        //a=5

        Var right = Var.createVar(line[1]);
        if(expression.contains("=")){
            return  Var.save(line[0],right);
        }
        Var left = Var.createVar(line[0]);

        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher match = pattern.matcher(expression);

            while (match.find()) {
                String operation = match.group();

                switch (operation) {
                    case "+":
                        return left.add(right);
                    case "-":
                        return left.sub(right);
                    case "*":
                        return left.mul(right);
                    case "/":
                        return left.div(right);
                }
            }
        }
        return null;
    }
}
