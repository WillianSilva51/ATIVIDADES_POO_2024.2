package exceptions;

public class ContatoNotFoundException extends EntidadeNotFound{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1600335032524758018L;

	private String contatoNaoEncontrado;

	public ContatoNotFoundException(String contatoId) {
		super("Cliente " + contatoId + " nao encotrado");
		contatoNaoEncontrado = contatoId;
	}

	public String getContatoNaoEncontrado() {
		return contatoNaoEncontrado;
	}
}
