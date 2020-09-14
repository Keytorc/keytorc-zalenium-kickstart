# Zalenium Nedir?

Zalenium, Zalando ve Selenium’ un isimleri sentezlenerek oluşmuş açık kaynak kodlu bir kütüphanedir. Testlerimizi farklı cihazlarda ve dağıtık bir biçimde test etmek istiyorsak Selenium Grid kullanabiliriz. Bu noktada Selenium versiyonları ve tarayıcı driverlarını güncel tutmamız gerekir, ayrıca kullanılacak remote cihazlar ve test ortamlarıda ekstra efor gerektirmektedir.   

Zalenium, Docker ile birlikte konteyner yapısını kullanırken gerekli tarayıcı driverlarını ve Selenium versiyonlarınıda güncel tutar. Testler Zalenium ile uzak bilgisayarlarda çalışırken test süresince ekranın videosunu kaydederek bize raporlar ve testlerin takibini ve raporlamasını daha kolay yapmamızı kolaylaştırır.  
Zalenium kullanarak sadece Chrome ve Firefoxta testlerimizi çalıştırabiliriz. 
Diğer tarayıcılar için Sauce Labs, BrowserStack gibi Remote sunucu hizmeti sunan firmaları kullanabiliriz.

## Hangi Platform ve Dilleri Destekler?  
Zalenium, Windows, Mac ve Linux üzerine kurulabilir.  
    Docker ve Kubernetes‘ i desteklemektedir.


## Zalenium Kullanmanın Avantajları Nelerdir?

*	Tarayıcı driverlarını yükler ve güncel tutar.

*	Selenium versiyonlarını güncel tutar

*	Birden fazla testi paralel olarak farklı tarayıcı ve ortamda çalıştırır.

* Testin canlı izlenmesine olanak sağlar ve kaydeder.


## Selenium Grid Nedir?
Selenium Grid, testlerimizi farklı ortamlarda ve cihazlarda paralel olarak koşmamızı sağlayan bir araçtır.    
Selenium Grid, Hub ve Node yapısını kullanır, Hub bir sunucu üzerinde merkez görevi görürken Node (gerçek veya sanal) remote cihazlardan oluşmaktadır. Hub driverları yöneterek Node' lara istenen komutları gönderir.

![](pictureForMd/1.jpg)

## Docker Nedir?
Docker, uygulamaların farklı ortamlarda çalıştırılması sürecinde kullanılan bir platformdur. Uygulamamızı derler, ölçeklendirir, paketler ve dağıtmamızı sağlar.     
Docker içerisinde barındırdığı container yapısını ve Docker Hub üzerinden indirilen image’ ları kullanarak ürünü farklı işletim sistemi, versiyon ve environment’ larla birbirinden izole şekilde çalıştırır.
Docker yeterli kaynak ve gerekli yapılandırmalar ile birlikte kullanıldığında, yapısal problemleri ortadan kaldırarak
uygulamalarımızı stabil bir şekilde çalışabilecek hale getirir.


## Containerization (Konteynerleştirme) Nedir? 

Containerization, bir sunucu üzerindeki işletim sisteminin diğer container’ lar tarafından paylaşılması demektir.Birbirinden farklı uygulamalar, dağıtımlar ve envrionment’ ları birbirinden izole şekilde çalıştırır.

Aşağıdaki görselin bir Linux ubuntu sunucusu olduğunu varsayalım, ortamlar birbirinden farklı dağıtımlara (Fedora, CentOs, Debian),
farklı environment’ lara ve kütüphanelere sahip olabilirler. Docker Hub üzerinden istenen İmage’ lar indirilir ve
Docker sunucu sistemindeki kernel’ ı kullanarak belirtilen dağıtım üzerinde uygulamamızı çalıştırır.
![](pictureForMd/2.png)  

Bu gibi farklı işletim sistemleri, versiyonları ve farklı environmentlarla uygulamalarımızı konteynerleştirebiliriz.



#  Zalenium ile esnek ve ölçeklenebilir konteyner tabanlı Selenium Grid uygulaması
## Gereksinimler
- Docker   
- Selenium Remote Test Projesi  
- Selenium Docker İmage  
- Zalenium Docker İmage


# Docker 


## Nasıl Yüklenir? (Windows)

1. https://hub.docker.com/editions/community/docker-ce-desktop-windows/ adresine gidilir. 
2. Get Stable ‘e tıklayıp indirme işlemi başlatılır.

![](pictureForMd\4.png)

3. Paketlerin indirilmesi beklenir.

![](pictureForMd/5.png)

<br />
<br />
<br />

4. Ok’a Basılır.

![](pictureForMd/6.png)

5. Paketlerin çıkarılması beklenir.

![](pictureForMd/7.png)

6. Close diyerek yükleme işlemlerini tamamlıyoruz.


## Nasıl Yüklenir? (Linux- ubuntu)

1.	https://docs.docker.com/engine/install/ubuntu/ adresine gidilir.
![](pictureForMd/8.png)
2.	İşletim sistemi gereksinimleri kontrol edilir. 

```
$ cat /etc/*release*
```
![](pictureForMd/9.png)

Docker, Ubuntu 18.04 e yüklenebilir durumda.

3. Docker eski versiyonları varsa silinir.
```
$ sudo apt-get remove docker docker-engine docker.io containerd runc
```
4. Curl ile Script dosyası indirilir.
```
$ Curl -fsSL https://get.docker.com -o get-docker.sh
```
5. Script çalıştırılır.
```
$ sudo sh get-docker.sh
```
6. Docker versiyonu ve yüklendiği kontrol edilir.
```
$ sudo docker version
```



<br />
<br />
<br />
<br />
<br />

# Selenium Remote Test Projesi

Gereksinimler : 
- Java jdk
- İntellij İdea ide
- Maven Proje (Maven, İntellij ile birlikte yükleniyor.)

<br />

### Java jdk 

1. https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html sitesine gidilir. Uygun bit seçilir. 

![](pictureForMd/10.png)

Giriş yapıldıktan sonra indirme işlemi başlayacaktır. Oracle hesabınız yoksa üye olmalısınız.

![](pictureForMd/11.png)

Yükleme işlemlerine geçilir.
1. Next

![](pictureForMd/12.png)

2. Next

![](pictureForMd/13.png)

3. Next

![](pictureForMd/14.png)

4. Close

![](pictureForMd/15.png)


<br />
<br />

### İntellij İdea ide

1.	https://www.jetbrains.com/idea/download/#section=windows Adresine giderek indirme işlemi başlatılır.

2.	Next Diyoruz.

![](pictureForMd/16.png)

3.	Kurulacak yeri seçip ardından next diyoruz.

![](pictureForMd/17.png)

<br />
<br />
<br />
<br />
<br />

4.	Kısayol seçimini yapıpı Next Diyoruz. 

![](pictureForMd/18.png)

5.	İnstall diyoruz.

![](pictureForMd/19.png)    


6.	Yüklenmesini bekliyoruz.

![](pictureForMd/20.png)


7.	Finish diyoruz. Kurulum işlemlerini tamamladık. 

![](pictureForMd/21.png)

<br />
<br />
<br />

8.	Şimdi İntellij idea başlatıp yeni bir proje oluşturalım.

![](pictureForMd/22.png)



### Maven Proje

1.	Maven projesi açılır.

![](pictureForMd/23.png)

<br />
<br />
<br />
<br />
<br />
2.	İsim verilir ve finish’e basılır.

![](pictureForMd/24.png)

3.	Pom.xml üzerinden gerekli kütüphaneler eklenir.  

```
    <dependencies>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.1.0</version>
            <scope>test</scope>
        </dependency>
         <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
            <scope>test</scope>
        </dependency>
    </dependencies>  

      <build>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
    
```

**Testng:** 
> Testi koşmak için gerekli bir test çerçevesidir. 

**Selenium:** 
> driverları ayağa kaldırmak ve test adımlarını uygulamak için gerekli kütüphanedir.


**Maven Compiler:** 
> Compile aşamasında herhangi bir sorunla karşılaşmamak için İndirilen jdk versiyonu seçilir.

<br />

4.	**Src > Test > java** klasörüne sağ tıklayıp **new > java class** diyerek Test Class’ ı oluşturulur.

![](pictureForMd/25.png)

<br />

5.	Remote Driver ve capabilites tanımlanır.

```
RemoteWebDriver driver;
DesiredCapabilities desiredCapabilities;
WebDriverWait wait;
```
<br />
<br />
<br /><br /><br /><br /><br />
<br /><br />


6.	Capabilites ve Driver, test başlamadan önce ayağa kalkacak şekilde tanımlanır.

```
    @BeforeClass
    public void setup() throws MalformedURLException {
        desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,Platform.LINUX);
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME,BrowserType.FIREFOX);
        URL url = new URL("http://localhost:4444/wd/hub ");
        driver = new RemoteWebDriver(url, desiredCapabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 15);
        driver.get("https://www.keytorc.com");
    }
```
7. Click Metodu Tanımlanır.

```
  public  void ClickElementsByXpath (String element, int x){
         wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.xpath(element)).get(x))).click();
     }
```

8.	Test adımları yazılır.

```
    @Test
    public void  test1(){
        ClickElementsByXpath("//a[@href= '/blog']", 0);
        ClickElementsByXpath("//a[@class= 'entire-meta-link']", 0);
        ClickElementsByXpath("//a[@href= '/blog']", 0);
        ClickElementsByXpath("//a[@class= 'entire-meta-link']", 1);
        ClickElementsByXpath("//a[@href= '/blog']", 0);
        ClickElementsByXpath("//a[@class= 'entire-meta-link']", 2);
    }
```  

9. Driver Kapatılır.

```
 @AfterTest()
    public void tearDown() {
        driver.quit(); 
    }
```
<br /><br />
<br /><br />
## IntelliJ'de Testng koşum konfigürasyonu nasıl hazırlanır?

1.	Testng.Xml dosyası oluşturulur.

![](pictureForMd/26.png)

2.	Xml dosyası içerisine Suite oluşturulur.

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite name="Web Suite" preserve-order="true" parallel="false" thread-count="2">

    <test name="firefox">
        <classes>
            <class name="tests.TestZalenium">
            </class>
           </classes>
       </test>
   </suite>
```
3.	Koşum konfigürasyonu eklenir.

* Sağ üstten Add Configuration’ a basılır.

![](pictureForMd/27.png)


* Artı İşaretine basılır.

![](pictureForMd/28.png)

<br />
<br />
<br />

* Listeden Testng Seçilir.

![](pictureForMd/29.png)

<br />
<br />

*	Name girilir, Test Kind Suite olarak seçilir ve yolu gösterilir

![](pictureForMd/30.png)

<br />
<br />
<br />

## Selenium ve Zalenium İmage olarak Nasıl İndirilir?

1.	Selenium image ‘ı indirilir.
```
$ Docker pull elgalu/selenium
```
2.	Zalenium image’ ı indirilir.

```
$ Docker pull dosel/zalenium
```
İmages aşağıdaki şekilde olmalıdır.

```
$ Docker images
```
![](pictureForMd/31.png)

 Container' i Başlatmak için aşağıdaki komut kullanılır.
 
 ```
 $ docker run --rm -ti --name zalenium -p 4444:4444 \
-v /var/run/docker.sock:/var/run/docker.sock \
-v /C:/Users/”kullanıcıAdı”/videos:/ Users/”kullanıcıAdı”/videos \
      --privileged dosel/zalenium start   

 ```
 
 Zalenium localhost:4444 portunda çalışmaya başlayacaktır.
 <br />
 <br />
 <br />

 
 
 Localhost:4444 portunu tarayıcımız üzerinden açtığımızda
 
 
 ![](pictureForMd/33.png)
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 
 
 Buradan console ‘a gelip node bilgilerini görüntüleyebiliriz.
 
 ![](pictureForMd/34.png)
 
 Testi canlı izlemek için ise Localhost:4444/grid/admin/live adresine gitmeliyiz.
 
 ![](pictureForMd/35.png)
 
 Daha önce hazırladığımız Testi başlatalım. 
  <br />
   <br />
 ![](pictureForMd/36.png)
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 
 Canlı olarak bakalım.
 
 ![](pictureForMd/37.png)
 <br />
 <br />
  <br />
   <br />
 
 
 Testin sonuçlarına ise localhost:4444/dashboard adresinden ulaşabiliriz.
  <br />
   <br />
 ![](pictureForMd/38.png)
 <br /> <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />

 
 Video kaydını tekrar izleyebilir.
 
 ![](pictureForMd/39.png)
 
 Log kaydını inceleyebiliriz.
 
 ![](pictureForMd/40.png)
 
 <br/><br/><br/>
 
 Teşekkürler,
 
 **FIRAT ÇELİK ~ TEST AUTOMATİON ENGİNEER**