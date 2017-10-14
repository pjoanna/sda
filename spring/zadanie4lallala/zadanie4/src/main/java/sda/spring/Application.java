package sda.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sda.spring.beans.ComposedBean;
import sda.spring.beans.DodawaczDoFaktury;
import sda.spring.beans.Faktura;
import sda.spring.beans.GeneratorPozycjiFaktury;
import sda.spring.beans.SimpleBean;
import sda.spring.beans.SumowaczFaktury;
import sda.spring.conf.ApplicationConfiguration;


public class Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
//		SimpleBean simple = applicationContext.getBean(SimpleBean.class);
//
//		System.out.println(simple.getValue());
//		
//		ComposedBean composed = (ComposedBean) applicationContext.getBean(ComposedBean.class);
//		//zauwaz ze beany domyslnie sa tworzone w jednej instancji dla calego kontekstu
//		System.out.println(composed.getSimple() == simple);
		
		//sprobuj dodac beana ktory w konstruktorze otrzyma wartosc z propertisow
		
		//dodaj metody @PostConstruct do beanow z zaleznosciami wstrzykiwanymi przez setter i zobacz kiedy pojawiaja sie zaleznosci
		
		//zamien application-context na ClassPathXmlApplicationContext i zaobserwuj jak xml nadpisuje adnotacje
		
		//zbudujmy strukture faktura- pozycje faktury - opis produktu, cena
		//zbudujmy serwis ktory bedzie tworzyc pozycje faktury, i drugi ktory bedzie dodawac dana pozycje do faktury
		//trzeci ktory bedzie nam wyszukiwal i zapisywal faktury "w bazie"
		//za baze danych niech sluzy HashMap<Long, Faktura>
		
		GeneratorPozycjiFaktury generator = applicationContext.getBean(GeneratorPozycjiFaktury.class);
		DodawaczDoFaktury dodawacz = applicationContext.getBean(DodawaczDoFaktury.class);
		SumowaczFaktury sumowacz = applicationContext.getBean(SumowaczFaktury.class);
		Faktura faktura = dodawacz.dodajDoFaktury(generator.stworz(), null);
		faktura = dodawacz.dodajDoFaktury(generator.stworz(), faktura.getId());
		sumowacz.podsumujFakture(faktura.getId());
		System.out.println(faktura);
		faktura = dodawacz.dodajDoFaktury(generator.stworz(), faktura.getId());
		sumowacz.podsumujFakture(faktura.getId());
		System.out.println(faktura);
		faktura = dodawacz.dodajDoFaktury(generator.stworz(), faktura.getId());
		sumowacz.podsumujFakture(faktura.getId());
		System.out.println(faktura);
		faktura = dodawacz.dodajDoFaktury(generator.stworz(), faktura.getId());
		sumowacz.podsumujFakture(faktura.getId());
		System.out.println(faktura);
		faktura = dodawacz.dodajDoFaktury(generator.stworz(), faktura.getId());
		sumowacz.podsumujFakture(faktura.getId());
		System.out.println(faktura);
	}
}






















































//https://stackoverflow.com/questions/4203302/how-to-inject-a-value-to-bean-constructor-using-annotations