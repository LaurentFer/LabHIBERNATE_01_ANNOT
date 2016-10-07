package client;
import org.hibernate.classic.Session;
import org.hibernate.stat.Statistics;
import org.hibernate.Transaction;

import modele.Formation;
import modele.util.HibernateUtil;
public class DemoHibernate {

	public static void main(String[] args) {
		
		Statistics stats = HibernateUtil.getSessionFactory().getStatistics();
		/*	
		// 1 : Cr�er une SessionFactory
		SessionFactory masessionFactory = new
		Configuration().configure().buildSessionFactory();
		
		// 2 : Ouvrir une nouvelle Session Hibernate
		Session masession = masessionFactory.openSession();
		// OU
		// 2 : R�cup�rer la Session courante d'Hibernate
		//Session masession = masessionFactory.getCurrentSession();
		 */
		Session masession = HibernateUtil.getSessionFactory().openSession();
		
		// 3 : D�buter une transaction
		Transaction tx = masession.beginTransaction();
		// Instanciation Objet m�tier
		Formation formation = new Formation("Hibernate_Annotation4");

		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
		Long formationId = (Long) masession.save(formation);
		System.out.println("Cl� primaire :" + formationId);
		
		// 5 : Valider la transaction en cours
		try {
			tx.commit();
		} catch (RuntimeException e){
			System.out.println("Transaction annul�e - Connexion impossible");
			tx.rollback();
		} finally {
			// 6 : Ponctuer la Session (flush) et fermer la Session
			masession.close();		
		}
		stats.logSummary();
		//EntityStatistics stats2 = stats.getEntityStatistics("FORMATIONS");
		//System.out.println(stats2.toString());
	}
}