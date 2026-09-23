package BanqueModule;

/**
 * Generated from IDL struct "CompteDTO".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at 23 sept. 2026, 03:07:44
 */

public final class CompteDTO
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public CompteDTO(){}
	public int id;
	public java.lang.String nom = "";
	public CompteDTO(int id, java.lang.String nom)
	{
		this.id = id;
		this.nom = nom;
	}
}
