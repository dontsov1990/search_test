package helpers;

public class LogHelper {

    public static String getTestName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String message = "";
        if(stackTraceElements.length >= 3) {
            StackTraceElement element = stackTraceElements[3];
            String className = element.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            String methodName = element.getMethodName();
            message = "[" + className + "." + methodName +"] ";
        }
        return message;
    }
}
