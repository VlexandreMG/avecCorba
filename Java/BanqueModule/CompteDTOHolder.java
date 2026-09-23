package BanqueModule;

/**
 * Generated from IDL struct "CompteDTO".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at 23 sept. 2026, 03:07:44
 */

public final class CompteDTOHolder
	implements org.omg.CORBA.portable.Streamable
{
	public BanqueModule.CompteDTO value;

	public CompteDTOHolder ()
	{
	}
	public CompteDTOHolder(final BanqueModule.CompteDTO initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return BanqueModule.CompteDTOHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = BanqueModule.CompteDTOHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		BanqueModule.CompteDTOHelper.write(_out, value);
	}
}
