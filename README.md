# keytorc-zalenium-kickstart

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



## Docker Nedir?
Docker, uygulamaların farklı ortamlarda çalıştırılması sürecinde kullanılan bir platformdur. Uygulamamızı derler, ölçeklendirir, paketler ve dağıtmamızı sağlar.     
Docker içerisinde barındırdığı container yapısını ve Docker Hub üzerinden indirilen image’ ları kullanarak ürünü farklı işletim sistemi, versiyon ve environment’ larla birbirinden izole şekilde çalıştırır.
Docker yeterli kaynak ve gerekli yapılandırmalar ile birlikte kullanıldığında, yapısal problemleri ortadan kaldırarak
uygulamalarımızı stabil bir şekilde çalışabilecek hale getirir.






#  Zalenium ile esnek ve ölçeklenebilir konteyner tabanlı Selenium Grid uygulaması
## Gereksinimler

- Docker   
- Selenium Remote Test Projesi  
- Selenium Docker İmage  
- Zalenium Docker İmage


# Docker 
## Nasıl Yüklenir? (Linux- ubuntu)

1. Curl ile Script dosyası indirilir.
```
$ Curl -fsSL https://get.docker.com -o get-docker.sh
```
2. Script çalıştırılır.
```
$ sudo sh get-docker.sh
```

# Selenium Remote Test Projesi
- İntellij İdea ide

Projeyi indirin. 



## Selenium ve Zalenium İmage ?

1.	Selenium image ‘ı indirilir.
```
$ Docker pull elgalu/selenium
```
2.	Zalenium image’ ı indirilir.

```
$ Docker pull dosel/zalenium
```

 Container' i Başlatmak için aşağıdaki komutlar kullanılır.
 
 Windows:
 ```
 $  docker run --rm -ti --name zalenium -p 4444:4444 ^
      -v /var/run/docker.sock:/var/run/docker.sock ^
      -v /c/Users/your_user_name/temp/videos:/home/seluser/videos ^
      --privileged dosel/zalenium start 

 ```
 
  Linux:
 ```
 $  docker run --rm -ti --name zalenium -p 4444:4444 \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/seluser/videos \
      --privileged dosel/zalenium start    

 ```
 
  Mac:
 ```
 $  docker run --rm -ti --name zalenium -p 4444:4444 \
      -e DOCKER=17.06.2-ce \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/seluser/videos \
      --privileged dosel/zalenium start   

 ```
 
 Zalenium localhost:4444 portunda çalışmaya başlayacaktır.

 Daha önce indirilen Testi başlatalım. 
 
 Testi canlı izlemek için,
 >  Localhost:4444/grid/admin/live

 Test Sonuçları için,
> localhost:4444/dashboard
 
 
 Video kaydını tekrar izleyebilir.
 
 Log kaydını inceleyebiliriz.
 
 
 **FIRAT ÇELİK ~ TEST AUTOMATİON ENGİNEER**
