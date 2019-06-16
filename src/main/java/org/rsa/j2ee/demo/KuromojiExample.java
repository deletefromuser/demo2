package org.rsa.j2ee.demo;

import java.util.List;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import com.mariten.kanatools.KanaConverter;

public class KuromojiExample {
	public static void main(String[] args) {
		Tokenizer tokenizer = new Tokenizer();
		List<Token> tokens = tokenizer.tokenize("<p itemprop=\"articleBody\" class=\"par13\">　地震列島の日本では、いつ大規模な揺れに見舞われるかわからない。備えを万全にしたい。</p>");
		for (Token token : tokens) {
			System.out.println(token.getSurface() + "\t" + getHelpString(token));
		}
	}

	public static String getHelpString(Token word) {
		return getHirakana(word)
				+ (word.getPartOfSpeechLevel1().equals("動詞") && word.getPartOfSpeechLevel2().equals("自立")
						? "|" + word.getBaseForm() : "");
	}

	public static String getHirakana(Token word) {
		return isCJK(word.getSurface())
				? KanaConverter.convertKana(word.getReading(), KanaConverter.OP_ZEN_KATA_TO_ZEN_HIRA) : "";
	}

	public static boolean isCJK(String word) {
		for (char i : word.toCharArray()) {
			Character.UnicodeBlock ub = Character.UnicodeBlock.of(i);
			if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {
				return true;
			}
		}
		return false;
	}
}