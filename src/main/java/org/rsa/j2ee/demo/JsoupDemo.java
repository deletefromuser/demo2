package org.rsa.j2ee.demo;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {
	public static void main(String[] args) throws IOException {
		Connection connection = Jsoup.connect("http://localhost:8080/docs/syasetsu.html").ignoreContentType(true)
				.ignoreHttpErrors(true).userAgent(
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
		int status = connection.execute().statusCode();
		if (status != 200) {
			System.out.println(status);
			return;
		}
		// https://www.yomiuri.co.jp/editorial
		Document doc = Jsoup.connect("http://localhost:8080/docs/moto2.html")
				.userAgent(
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36")
				.ignoreHttpErrors(true).timeout(20 * 1000).get();
		System.out.println(doc.title());
		Elements news = doc
				.select("[class^='p-list-item'] [class^='p-list-item__inner'] .c-list-title a[href*='editorial']");
		for (Element headline : news) {
			System.out.printf("%s\n\t%s\n", headline.text(), headline.absUrl("href"));
		}

		Document doc1 = Jsoup.connect("http://localhost:8080/docs/moto.html").get();
		System.out.println(doc1.title());
		Elements newsHeadlines = doc1.select(".p-main-contents");
		for (Element headline : newsHeadlines) {
			System.out.printf("%s\n", headline.html());
		}
	}
}
