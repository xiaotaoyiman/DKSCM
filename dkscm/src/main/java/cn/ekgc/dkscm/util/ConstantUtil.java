package cn.ekgc.dkscm.util;

import java.util.Properties;

public class ConstantUtil {
	private static Properties props = new Properties();
	
	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("config/props/dkscm.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));
	
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));
	
	public static final String STATUS_ENABLE = props.getProperty("status.enable");
	
	public static final String STATUS_DISABLE = props.getProperty("status.disable");
	
	public static final String STATUS_RESCIND = props.getProperty("status.rescind");
	
	public static final String STATUS_APPLY = props.getProperty("status.apply");
	
	public static final String STATUS_REVIEW = props.getProperty("status.review");
	
	public static final String STATUS_PURCHASE = props.getProperty("status.purchase");
	
	public static final String STATUS_REPO_REVIEW = props.getProperty("status.repo.review");
	
	public static final String STATUS_REPO = props.getProperty("status.repo");
	
	public static final String STATUS_RECEIVE = props.getProperty("status.rececive");
	
	public static final String STATUS_REVIEW_BACK = props.getProperty("status.review.back");
	
	public static final String STATUS_REPO_BACK = props.getProperty("status.repo.back");
}
