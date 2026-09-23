package BanqueModule;


/**
 * Generated from IDL interface "banqueService".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at 23 sept. 2026, 03:07:44
 */

public abstract class banqueServicePOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, BanqueModule.banqueServiceOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "faireDepot", Integer.valueOf(0));
	}
	private String[] ids = {"IDL:BanqueModule/banqueService:1.0"};
	public BanqueModule.banqueService _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		BanqueModule.banqueService __r = BanqueModule.banqueServiceHelper.narrow(__o);
		return __r;
	}
	public BanqueModule.banqueService _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		BanqueModule.banqueService __r = BanqueModule.banqueServiceHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // faireDepot
			{
				int _arg0=_input.read_long();
				double _arg1=_input.read_double();
				_out = handler.createReply();
				_out.write_boolean(faireDepot(_arg0,_arg1));
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
