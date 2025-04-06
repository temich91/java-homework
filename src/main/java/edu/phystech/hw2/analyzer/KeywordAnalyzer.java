package edu.phystech.hw2.analyzer;

import java.util.List;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    private final List<String> keywords;
    private final Label label;

    public KeywordAnalyzer(List<String> keywords, Label label) {
        this.keywords = keywords;
        this.label = label;
    }

    @Override
    public Label processText(String text) {
        int textSize = text.length();
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        for (String keyword : keywords) {
            int i = 0;
            int keywordSize = keyword.length();
            while (i + keywordSize <= textSize) {
                String substr = text.substring(i, i + keywordSize);
                if (substr.equals(keyword)) {
                    if (i + keywordSize - 1 == textSize) {
                        return label;
                    }
                    if ((i > 0) && (LETTERS.indexOf(text.charAt(i - 1)) == -1)) {
                        return label;
                    }

                    if ((i + keywordSize < textSize) && (LETTERS.indexOf(text.charAt(i + 1)) == -1)) {
                        return label;
                    }
                }
                i++;
            }
        }
        return Label.OK;
    }
}
