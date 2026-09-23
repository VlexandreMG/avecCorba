package BanqueModule;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "banqueService".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at 23 sept. 2026, 03:07:44
 */

public class banqueServicePOATie
	extends banqueServicePOA
{
	private banqueServiceOperations _delegate;

	private POA _poa;
	public banqueServicePOATie(banqueServiceOperations delegate)
	{
		_delegate = delegate;
	}
	public banqueServicePOATie(banqueServiceOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public banqueServiceOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(banqueServiceOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public boolean faireDepot(int idCompte, double montant)
	{
		return _delegate.faireDepot(idCompte,montant);
	}

}
