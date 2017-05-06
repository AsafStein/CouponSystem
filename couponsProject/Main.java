package couponsProject;

import Facades.AdminFacade;
import Facades.CompanyFacade;
import Facades.CustomerFacade;
import couponsProject.DAO.CompanyDBDAO;
import util.StringDateConvertor;

public class Main {

	public static void main(String[] args) throws Exception {
		Company comp = new Company("test", "1234", "test@gmail.com");
		Company comp1 = new Company("test1", "1234", "test1@gmail.com");
		Company comp2 = new Company("test2", "1234", "test2@gmail.com");
		Company comp3 = new Company("test3", "1234", "test3@gmail.com");
		Company comp4 = new Company("test4", "1234", "test4@gmail.com");

		Customer cust = new Customer("cust", "1234");
		Customer cust1 = new Customer("cust1", "1234");
		Customer cust2 = new Customer("cust2", "1234");
		Customer cust3 = new Customer("cust3", "1234");
		Customer cust4 = new Customer("cust4", "1234");

		Coupon coup = new Coupon("coup", StringDateConvertor.convert("2017-04-17"),
				StringDateConvertor.convert("2018-04-17"), 12, CouponType.CAMPING, "asdasd", 12, "dsffxc ");
		coup.setId(1);

		Coupon coup1 = new Coupon("coup1", StringDateConvertor.convert("2017-04-17"),
				StringDateConvertor.convert("2018-04-17"), 12, CouponType.FOOD, "asdasd", 12, "dsffxc ");
		coup1.setId(2);

		Coupon coup2 = new Coupon("coup2", StringDateConvertor.convert("2017-04-17"),
				StringDateConvertor.convert("2018-04-17"), 12, CouponType.ELECTRICITY, "asdasd", 12, "dsffxc ");
		coup.setId(1);

		Coupon coup3 = new Coupon("coup3", StringDateConvertor.convert("2017-04-17"),
				StringDateConvertor.convert("2018-04-17"), 12, CouponType.HEALTH, "asdasd", 12, "dsffxc ");
		coup.setId(1);

		Coupon coup4 = new Coupon("coup4", StringDateConvertor.convert("2017-04-17"),
				StringDateConvertor.convert("2018-04-17"), 12, CouponType.MOBILE, "asdasd", 12, "dsffxc ");
		
	
		AdminFacade af = (AdminFacade) CouponSystem.getInstance().login("admin", "1234", ClientType.Admin);
		af.createCompany(comp);
		af.createCompany(comp1);
		af.createCompany(comp2);
		af.createCompany(comp3);
		af.createCompany(comp4);
		
		af.createCustomer(cust);
		af.createCustomer(cust1);
		af.createCustomer(cust2);
		af.createCustomer(cust3);
		af.createCustomer(cust4);
		
		System.out.println(af.getAllCompanies());
		System.out.println(af.getAllCustomer());
		System.out.println(af.getCompany(1));
		System.out.println(af.getCustomer(1));
		af.removeCompany(comp4);
		af.removeCustomer(cust);
		af.updateCompany(2, comp4);
		af.updateCustomer(2, cust4);
		
		
		CompanyFacade cf = (CompanyFacade) CouponSystem.getInstance().login("test", "1234", ClientType.Company);
		
		cf.createCoupon(coup);
		cf.createCoupon(coup1);
		cf.createCoupon(coup2);
		cf.createCoupon(coup3);
		cf.createCoupon(coup4);
		
		System.out.println(cf.getCoupon(2));
		System.out.println(cf.getAllCoupon());
		System.out.println(cf.getCouponByType(CouponType.CAMPING));
		cf.removeCoupon(coup);
		cf.updateCoupon(3, coup4);
		
		CustomerFacade cuF = (CustomerFacade) CouponSystem.getInstance().login("cust", "1234", ClientType.Customer);
		cuF.purchaseCoupon(coup);
		cuF.purchaseCoupon(coup1);
		cuF.purchaseCoupon(coup2);
		System.out.println(cuF.getAllPurchasedCoupons());
		System.out.println(cuF.getAllPurchasedCouponsByPrice(12, cust2));

		CouponSystem.getInstance().shutdown();
	

	}
}
