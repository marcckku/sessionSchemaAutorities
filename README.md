
	 .   ____          _            __ _
	 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
	( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
	 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
	  '  |____| .__|_| |_|_| |_\__, | / / / /
	 =========|_|==============|___/=/_/_/_/
	 :: Spring Boot ::        (v2.3.2.RELEASE)

      ESEMPIO DI SESSION IN SPRING BOOT 2
	  
	  Descrizione :
	  > Questa applicazione è basata in SpringBoot 2, crea le tabelle Session di default di Spring per ogni Utente. 
	  > Puoi cambiare il packaging da jar a war se vuoi una webapp.
		
	  > Crea le tabelle User e LoginUser.
	  
	  > Per creare un LoginUser utilizza il Controller [ LoginController ] 
	    - LoginUser è una Entità che puoi anche cancellarla e lasciare soltanto la classe User al posto di LoginUser.
		- Alttimenti :
		////////////////// CREA UN LoginUser AVVIANDO IL TOMCAT E INSERISCI DIRETTAMENTE COPIANDO GLI URL QUI SOTTO
		/////////////////
		/////////////////   http://localhost:8786/create/admin/admin@gmail.com/admin
		/////////////////   http://localhost:8786/create/user/user@gmail.com/user
		
		/////////////////  1) ADMIN ::  username: admin@gmail.com  con password: admin enabled=1    role:ROLE_ADMIN
		/////////////////  2) USER  ::  username: root2@gmail.com  con password: user  enabled=1    role:ROLE_USER
	    
		- User  creazione nel main di:
	    /////////////////  Sarà anche creato un User con username:admin e password:admin
		
      > Contiene actuator e hateos molto importanti per creare dei veri Servizi Rest in Spring. In più devtool che ti aiuta 
	    a ricompilare immediatamente il tuo progetto senza spegnere il Servlet Container Embedded (Tomcat).
	  
	  > Al momento dell'avvio del Tomcat apparirà un form Login di default di Spring in cui dovrai inserire il username e password, 
	    vedi file properties.

	  > Puoi usare i templates .ftlh grazie a spring-boot-starter-freemarker. E' abilitato anche per usare le JSP page.
	    - Puoi anche configurare Freemarker nel file properties, nel mio caso ho configurato nel SecurityWebConfiguration.java 
	  
	  > Dalle versioni successive alla 5.x Mysql ha cambiato la classe del driver in :
						[ spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver ]
						
	  > Troverai anche il ddl per creare tabelle per mappare gli users e le autorita 
	                     [ mysql-spring-schema-users-authorities.sql ]
	    ma è consigliabile lasciare alla applicazione che lei crei le tabelle User e Autority grazie a JPA e mappi in automatico le 
		associazioni.
		
      > C'è un esempio di un form login html in resources/templates/ se non vuoi lasciare a Spring il suo form di Login di default, 
	    ma dovrai mappare con la entita User al suo omonimo controller (form -> User(campi)) per dirle a Spring che stai usando il User.
		
     > Questo Progetto può essere stesso per creare una applicazione anche senza le Tabelle Session e quindi soltanto usare il Token
       (JWT).	 
		
	> E' abilitato anche il file di log modo produzione in [ logback-spring.xml ] quindi ti creerà un file sessionSchemaAutorities.log,
	  vedi file properties.
	  - Viene utilizzata la annotazione [ @Slf4j ] per il [ log.info("msg")] importato dal package [lombok.extern.slf4j.Slf4j] 
	
	
	>NOTA: Decomenta nel file di properties [logging.file.name] e [spring.profiles.active] se vuoi un file chiamato 
	 - sessionSchemaAutorities.log per un ambiente di Produzione.
	
	
	
	Scarica questo tutorial qui da command line: 
	+ git remote add origin https://github.com/marcckku/sessionSchemaAutorities.git
    + git push -u origin master
	
	
		
