#  Spring To Do  Uygulaması
* Bu uygulamanın amacı Yapılack listeleri eklemek ve onlara ait yapılacaklar eklemek.

### Uygulamınn Bazı Özellikleri
* Liste Eklemek,Güncellemek ve Listelemek.
* Item Eklemek,Güncellemek,Silmek ve Listelemek.
####Opsiyonel kriterlerden yaptıklarım :
* Test içeriyor.
* Ön yüz yapıldı.

## Kullandığım Teknolojiler
* Spring Boot
* H2 Database
* Thymeleaf
* Bootstrap
* Spring Data JPA
* JDK 17
* Maven
* IntelliJ IDE

## Projeye Nasıl Çalıştırılır ?
* Projeyi bu adresten indirmeniz gerekiyor :[proje linki](https://github.com/Furkan-Ahmet-Ozdemir/Spring-todo_app)
* Projeyi zipten çıkarın.

### IDE Gerekmeden Çalıştırmak İçin:
* Bilgisayarınızda maven kurulu olmalı. Kurulu değil ise buradan kurabilirsiniz: [https://maven.apache.org/download.cgi]
* Pathe tanımlı olmalı. Tanımlı değil ise buradan bakabilirsiniz: [https://mkyong.com/maven/how-to-install-maven-in-windows/]
* Cmd ye ```mvn --version``` yazıp entera basın. ``` Apache Maven 3.8.4 ``` benzeri bir cevap almalısınız.
* Projeyi zip te ise ziptan çıkartın.
* Daha sonra CMD yi açıp **pom.xml**  in olduğu dizine gelin.
* ```mvn spring-boot:run``` komutunu çalıştırın.Bu komutla aynı zamanda testleride çalıştırmış oluyoruz.
* Aşağıdaki yazıya benzer yazılar geliyorsa proje çalışmıştır :
```
Tomcat started on port(s): 8080 (http) with context path ''  
Started VetApplication in 3.574 seconds (JVM running for 3.991)
```

* Tarayıcınız açıp http://localhost:8080/ adresine gidin.

### IntelliJ IDE İle Çalıştırmak İçin:
* Projeyi IntelliJ IDE ile açın.
* ```Run TodoAppApplication``` 
* Run kısmında aşağıdaki yazıya benzer yazılar geliyorsa proje çalışmıştır :
```
Tomcat started on port(s): 8080 (http) with context path ''  
Started VetApplication in 3.574 seconds (JVM running for 3.991)
```

* Tarayıcınız açıp http://localhost:8080/ adresine gidin.

## Teknik Seçimler / Kabuller Ve Nedenleri
* Uygulama ilke açıldığında Create Item butonuna basıldığında bir mesaj ile Create List sayfasına yönlendiriyorum.
  Nedeni hiç Liste olmadan Item oluşturulamaması için.

