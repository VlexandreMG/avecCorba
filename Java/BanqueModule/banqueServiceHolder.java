package BanqueModule;

/**
 * Generated from IDL interface "banqueService".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at 23 sept. 2026, 03:07:44
 */

public final class banqueServiceHolder	implements org.omg.CORBA.portable.Streamable{
	 public banqueService value;
	public banqueServiceHolder()
	{
	}
	public banqueServiceHolder (final banqueService initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return banqueServiceHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = banqueServiceHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		banqueServiceHelper.write (_out,value);
	}
}
