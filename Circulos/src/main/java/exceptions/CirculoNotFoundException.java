package exceptions;

public class CirculoNotFoundException extends EntidadeNotFound{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7331861696548215622L;

	private String circuloNaoEncontrado;

	public CirculoNotFoundException(String circuloId) {
		super("Circulo " +  circuloId + " nao foi encontrado");
		circuloNaoEncontrado = circuloId;
	}

	public String getCirculoNaoEncontrado() {
		return circuloNaoEncontrado;
	}
}
