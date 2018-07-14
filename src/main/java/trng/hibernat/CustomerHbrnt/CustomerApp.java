package trng.hibernat.CustomerHbrnt;

import trng.hibernat.utils.HibernateUtils;

public class CustomerApp{
	public static void main(String args[]) {
		HibernateUtils.getSessionFactory();
	}
}