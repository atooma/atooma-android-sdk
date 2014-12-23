package com.atooma.module.core;

import java.io.Serializable;

/**
 * Un filtro per i numerici.
 */
public class NumberFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Tipologia di filtro <em>minore</em>.
	 */
	public static final int LESS = 0;
	/**
	 * Tipologia di filtro <em>uguale</em>.
	 */
	public static final int EQUAL = 1;
	/**
	 * Tipologia di filtro <em>maggiore</em>.
	 */
	public static final int GREATER = 2;

	/**
	 * La tipologia di filtro.
	 */
	private int type;

	/**
	 * Il valore da utilizzare come termine di paragone.
	 */
	private Double match;

	/**
	 * Costruisce un NumberFilter.
	 * 
	 * @param type
	 *            Il tipo di filtro
	 * @param match
	 *            Il valore usata come filtro
	 */
	public NumberFilter(int type, Double match) {
		this.type = type;
		this.match = match;
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
	 * Restituisce il valore da utilizzare come termine di paragone.
	 * 
	 * @return Il valore da utilizzare come termine di paragone
	 */
	public Double getMatch() {
		return match;
	}

	/**
	 * Imposta il valore da utilizzare come termine di paragone.
	 * 
	 * @param match
	 *            Il valore da utilizzare come termine di paragone
	 */
	public void setMatch(Double match) {
		this.match = match;
	}

	/**
	 * Filtra una numero secondo la definizione di questo {@link NumberFilter},
	 * restituendo <code>true</code> se il valore in esame soddisfa i criteri
	 * impostati.
	 * 
	 * @param test
	 *            Il valore da esaminare
	 * @return true se il valore in esame soddisfa i criteri impostati,
	 *         altrimenti false
	 */
	public boolean filter(Double test) {
		if (test == null || match == null) {
			return false;
		}
		double v1 = test.doubleValue();
		double v2 = match.doubleValue();
		switch (type) {
		case LESS:
			return v1 < v2;
		case EQUAL:
			return v1 == v2;
		case GREATER:
			return v1 > v2;
		}
		return false;
	}

}
