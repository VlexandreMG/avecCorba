package BanqueModule;


/**
 * Generated from IDL struct "CompteDTO".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at 23 sept. 2026, 03:07:44
 */

public abstract class CompteDTOHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(CompteDTOHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_struct_tc(BanqueModule.CompteDTOHelper.id(),"CompteDTO",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("id", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null),new org.omg.CORBA.StructMember("nom", org.omg.CORBA.ORB.init().create_string_tc(0), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final BanqueModule.CompteDTO s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static BanqueModule.CompteDTO extract (final org.omg.CORBA.Any any)
	{
		org.omg.CORBA.portable.InputStream in = any.create_input_stream();
		try
		{
			return read (in);
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (java.io.IOException e)
			{
			throw new RuntimeException("Unexpected exception " + e.toString() );
			}
		}
	}

	public static String id()
	{
		return "IDL:BanqueModule/CompteDTO:1.0";
	}
	public static BanqueModule.CompteDTO read (final org.omg.CORBA.portable.InputStream in)
	{
		BanqueModule.CompteDTO result = new BanqueModule.CompteDTO();
		result.id=in.read_long();
		result.nom=in.read_string();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final BanqueModule.CompteDTO s)
	{
		out.write_long(s.id);
		java.lang.String tmpResult0 = s.nom;
out.write_string( tmpResult0 );
	}
}
