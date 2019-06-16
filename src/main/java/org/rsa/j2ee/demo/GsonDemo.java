package org.rsa.j2ee.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.rsa.j2ee.demo.GsonDemo.Dto.Sub;

import com.google.gson.Gson;

public class GsonDemo {

	public static void main(String[] args) {
		Dto d1 = new Dto();
		d1.setA(new Date());
		d1.setB(new Timestamp(new Date().getTime()));
		List<String> c1 = new ArrayList<>();
		c1.add("abc");
		c1.add("");
		c1.add("null");
		c1.add(null);
		d1.setC(c1);
		List<Sub> subd = new ArrayList<>();
		subd.add(new Sub("a"));
		subd.add(new Sub(""));
		subd.add(new Sub("null"));
		subd.add(new Sub(null));
		d1.setD(subd);

		Gson gson = new Gson();
		String json = gson.toJson(d1);
		System.out.println(json);
		Dto rd = gson.fromJson(json, Dto.class);
		System.out.println(rd.getD().get(3).getAa());
	}

	static class Dto {
		private Date a;
		private Timestamp b;
		private List<String> c;
		private List<Sub> d;

		public Date getA() {
			return a;
		}

		public void setA(Date a) {
			this.a = a;
		}

		public Timestamp getB() {
			return b;
		}

		public void setB(Timestamp b) {
			this.b = b;
		}

		public List<String> getC() {
			return c;
		}

		public void setC(List<String> c) {
			this.c = c;
		}

		public List<Sub> getD() {
			return d;
		}

		public void setD(List<Sub> d) {
			this.d = d;
		}

		static class Sub {
			public Sub(String aa) {
				this.aa = aa;
			}

			private String aa;

			public String getAa() {
				return aa;
			}

			public void setAa(String aa) {
				this.aa = aa;
			}
		}
	}

}
