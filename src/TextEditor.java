import java.util.Stack;

public class TextEditor {

    public StringBuilder text;
    public String insert;

    TextEditor(StringBuilder text, String insert){
        this.text = text;
        this.insert = insert;
    }

    public void undo(){
        text.delete(text.length()- insert.length(), text.length());
    }

    public static void main(String args[]){
        Stack<TextEditor> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        TextEditor textEditor = new TextEditor(stringBuilder, "Hello");
        stringBuilder.append("Hello");

        stack.push(textEditor);

        TextEditor textEditor2 = new TextEditor(stringBuilder, "World");
        stringBuilder.append("World");

        stack.push(textEditor2);

        System.out.println(stringBuilder);

        if(!stack.isEmpty()){
            TextEditor textEditor1 = stack.pop();
            textEditor1.undo();
        }
        System.out.println(stringBuilder);
    }
}
