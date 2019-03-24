package dictionary;

import java.util.ArrayList;

public class Dictionary {

    private String[] words1 = {"something", "right", "hearth", "wonderful"};
    private String[] words2 = {"mathematics", "software", "engineer", "logical"};
    private String[] words3 = {"anarchy", "hierarchy", "democracy", "republic"};
    private String[] words4 = {"witches", "magical", "wishes", "sorceress"};
    private String[] words5 = {"light", "darkness", "sunshine", "pudding"};
    private String[] words6 = {"apricot", "orange", "cucumber", "banana"};
    private String[] words7 = {"divine", "holistic", "believe", "bravery"};
    private String[] words8 = {"silence", "eternity", "mystic", "psychic"};
    private ArrayList<String[]> listOfWords;

    public Dictionary() {
        this.listOfWords = createDictionary();

    }

    public ArrayList<String[]> getListOfWords() {
        return listOfWords;
    }

    private ArrayList<String[]> createDictionary() {
        listOfWords = new ArrayList<>();
        listOfWords.add(words1);
        listOfWords.add(words2);
        listOfWords.add(words3);
        listOfWords.add(words4);
        listOfWords.add(words5);
        listOfWords.add(words6);
        listOfWords.add(words7);
        listOfWords.add(words8);
        return listOfWords;
    }
}
