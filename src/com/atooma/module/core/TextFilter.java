package com.atooma.module.core;

import java.io.Serializable;

/**
 * Un filtro per stringhe di testo.
 */
public class TextFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Tipologia di filtro <em>eguaglia</em>.
	 */
	public static final int EQUALS = 0;

	/**
	 * Tipologia di filtro <em>contiene</em>.
	 */
	public static final int CONTAINS = 1;

	/**
	 * Tipologia di filtro <em>inizia con</em>.
	 */
	public static final int STARTS_WITH = 2;

	/**
	 * Tipologia di filtro <em>termina con</em>.
	 */
	public static final int ENDS_WITH = 3;

	/**
	 * La tipologia di filtro.
	 */
	private int type;

	/**
	 * La stringa da utilizzare come termine di paragone.
	 */
	private String match;

	/**
	 * Il flag per la sensibilit&agrave alle maiuscole.
	 */
	private boolean caseSensitive = false;

	/**
	 * Costruisce un TextFilter non sensibile alle maiuscole.
	 * 
	 * Equivale a invocare {@link #TextFilter(int, String, boolean)} con i
	 * parametri <em>type</em>, <em>match</em> e <code>false</code>.
	 * 
	 * @param type
	 *            Il tipo di filtro
	 * @param match
	 *            La stringa usata come filtro
	 */
	public TextFilter(int type, String match) {
		this.type = type;
		this.match = match;
	}

	/**
	 * Costruisce un TextFilter.
	 * 
	 * @param type
	 *            Il tipo di filtro
	 * @param match
	 *            La stringa usata come filtro
	 * @param caseSensitive
	 *            Definisce la sensibilit&agrave; alle maiuscole
	 */
	public TextFilter(int type, String match, boolean caseSensitive) {
		this.type = type;
		this.match = match;
		this.caseSensitive = caseSensitive;
	}

	/**
	 * Restituisce la tipologia di filtro.
	 * 
	 * @return La tipologia di filtro
	 */
	public int getType() {
		return type;
	}

	/**
	 * Imposta la tipologia di filtro.
	 * 
	 * @param type
	 *            La tipologia di filtro
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Restituisce la stringa da utilizzare come termine di paragone.
	 * 
	 * @return La stringa da utilizzare come termine di paragone
	 */
	public String getMatch() {
		return match;
	}

	/**
	 * Imposta la stringa da utilizzare come termine di paragone.
	 * 
	 * @param match
	 *            La stringa da utilizzare come termine di paragone
	 */
	public void setMatch(String match) {
		this.match = match;
	}

	/**
	 * Restituisce il flag per la sensibilit&agrave alle maiuscole.
	 * 
	 * @return Il flag per la sensibilit&agrave alle maiuscole
	 */
	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	/**
	 * Imposta il flag per la sensibilit&agrave alle maiuscole.
	 * 
	 * @param caseSensitive
	 *            Il flag per la sensibilit&agrave alle maiuscole
	 */
	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	/**
	 * Filtra una stringa di testo secondo la definizione di questo
	 * {@link TextFilter}, restituendo <code>true</code> se la stringa in esame
	 * soddisfa i criteri impostati.
	 * 
	 * @param test
	 *            La stringa da esaminare
	 * @return true se la stringa in esame soddisfa i criteri impostati,
	 *         altrimenti false
	 */
	public boolean filter(String test) {
		if (test == null) {
			return false;
		}
		String actualMatch = caseSensitive ? match : match.toLowerCase();
		String actualTest = caseSensitive ? test : test.toLowerCase();
		switch (type) {
		case EQUALS:
			return actualTest.equals(actualMatch);
		case CONTAINS:
			return actualTest.contains(actualMatch);
		case STARTS_WITH:
			return actualTest.startsWith(actualMatch);
		case ENDS_WITH:
			return actualTest.endsWith(actualMatch);
		}
		return false;
	}

}
