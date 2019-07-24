package application;

import java.util.Random;


public class LaunchClass {
	
	private String dictFile = "data/dict.txt";
	
	LaunchClass() {
		super();
	}
	
	document.Document getDocument(String text) {
		// Change this to BasicDocument(text) for week 1 only
		return new document.EfficientDocument(text);
	}
	
	textgen.MarkovTextGenerator getMTG() {
		return new textgen.MarkovTextGeneratorLoL(new Random());
	}
	
	spelling.WordPath getWordPath() {
		return new spelling.WPTree();
	}
	
    spelling.AutoComplete getAutoComplete() {
        spelling.AutoCompleteDictionaryTrie tr = new spelling.AutoCompleteDictionaryTrie();
        spelling.DictionaryLoader.loadDictionary(tr, dictFile);
        return tr;
    }
    
    public spelling.Dictionary getDictionary() {
        spelling.Dictionary d = new spelling.DictionaryBST();
        spelling.DictionaryLoader.loadDictionary(d, dictFile);
    	return d;
    }
    
    spelling.SpellingSuggest getSpellingSuggest(spelling.Dictionary dic) {
    	//return new spelling.SpellingSuggestNW(new spelling.NearbyWords(dic));
    	return new spelling.NearbyWords(dic);
    
    }
}
