public class TextState {
    private String textBeforeChange;
    private String textAfterChange;
    private String textReplaced;
    private String textReplacement;

    public TextState(String textBeforeChange, String textAfterChange, String textReplaced, String textReplacement) {
        this.textBeforeChange = textBeforeChange;
        this.textAfterChange = textAfterChange;
        this.textReplaced = textReplaced;
        this.textReplacement = textReplacement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Text before: ");
        sb.append(textBeforeChange);
        sb.append("\nText after: ");
        sb.append(textAfterChange);
        sb.append("\nText replaced: ");
        sb.append(textReplaced);
        sb.append("\nText replacement: ");
        sb.append(textReplacement);
        return sb.toString();
    }

    public String getTextAfterChange() {
        return textAfterChange;
    }
}
