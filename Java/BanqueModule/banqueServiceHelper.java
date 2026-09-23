package BanqueModule;


/**
 * Generated from IDL interface "banqueService".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at 23 sept. 2026, 03:07:44
 */

public abstract class banqueServiceHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(banqueServiceHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:BanqueModule/banqueService:1.0", "banqueService");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final BanqueModule.banqueService s)
	{
			any.insert_Object(s);
	}
	public static BanqueModule.banqueService extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:BanqueModule/banqueService:1.0";
	}
	public static banqueService read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(BanqueModule._banqueServiceStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final BanqueModule.banqueService s)
	{
		_out.write_Object(s);
	}
	public static BanqueModule.banqueService narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof BanqueModule.banqueService)
		{
			return (BanqueModule.banqueService)obj;
		}
		else if (obj._is_a("IDL:BanqueModule/banqueService:1.0"))
		{
			BanqueModule._banqueServiceStub stub;
			stub = new BanqueModule._banqueServiceStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static BanqueModule.banqueService unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof BanqueModule.banqueService)
		{
			return (BanqueModule.banqueService)obj;
		}
		else
		{
			BanqueModule._banqueServiceStub stub;
			stub = new BanqueModule._banqueServiceStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
