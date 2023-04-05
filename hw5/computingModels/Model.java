package computingModels;

public class Model implements Computable {

    public String compute(String string) {
        String convertString = Converter.converteToPostfix(string);
        String result = Calculator.calculation(convertString);
        return result;

    }
}
