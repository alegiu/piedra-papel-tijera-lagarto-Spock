package edu.tallerweb.pptls;

/**
 * Representa una de las Manos involucradas en el juego
 */
public class Mano {

	/**
	 * Toda Mano debe crearse con una forma dada, que será
	 * la que determine su condición en el juego.
	 * @param forma, la Forma que adopta la Mano.
	 */
	private final Forma forma;

	public Mano(final Forma forma) {

		this.forma = forma;

		if (forma == null) {
		
			throw new RuntimeException("No implementado aún");
		}
	}

	/**
	 * Evaluará el resultado de la partida según las reglas
	 * del juego.
	 * @param otra, la otra Mano.
	 * @return un Resultado, de acuerdo al estado del juego.
	 */
	public Resultado jugarCon(final Mano otra) {

		Integer manoUno = this.forma.getValor();
		Integer manoDos = otra.forma.getValor();

		/**
		 * Piedra le gana a lagarto y a tijera
		 */
		if ((manoUno == 0) && (manoDos > 2)) {

			return Resultado.GANA;

		}

		/**
		 * Spock le gana a piedra y a tijera
		 */
		if ((manoUno == 1) && (manoDos == 0 || manoDos == 4)) {

			return Resultado.GANA;

		}

		/**
		 * Papel le gana a a piedra y a Spock
		 */
		if ((manoUno == 2) && (manoDos < 2)) {

			return Resultado.GANA;

		}

		/**
		 * Lagarto gana a Spock y a papel
		 */
		if ((manoUno == 3) && (manoDos == 1 || manoDos == 2)) {

			return Resultado.GANA;

		}

		/**
		 * Tijera le gana a papel y a lagarto
		 */
		if ((manoUno == 4) && (manoDos == 2 || manoDos == 3)) {

			return Resultado.GANA;

		}

		/**
		 * En caso de empate.
		 */
		if (this.forma.equals(otra.forma)) {

			return Resultado.EMPATA;

		}

		return Resultado.PIERDE;
	}

}
