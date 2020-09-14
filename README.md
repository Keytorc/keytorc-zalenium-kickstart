# keytorc-zalenium-kickstart

# Zalenium Nedir?

Zalenium, Zalando ve Selenium’ un isimleri sentezlenerek oluşmuş açık kaynak kodlu bir kütüphanedir. Testlerimizi farklı cihazlarda ve dağıtık bir biçimde test etmek istiyorsak Selenium Grid kullanabiliriz. Bu noktada Selenium versiyonları ve tarayıcı driverlarını güncel tutmamız gerekir, ayrıca kullanılacak remote cihazlar ve test ortamlarıda ekstra efor gerektirmektedir.   

Zalenium, Docker ile birlikte konteyner yapısını kullanırken gerekli tarayıcı driverlarını ve Selenium versiyonlarınıda güncel tutar. Testler Zalenium ile uzak bilgisayarlarda çalışırken test süresince ekranın videosunu kaydederek bize raporlar ve testlerin takibini ve raporlamasını daha kolay yapmamızı kolaylaştırır.  
Zalenium kullanarak sadece Chrome ve Firefoxta testlerimizi çalıştırabiliriz. 
Diğer tarayıcılar için Sauce Labs, BrowserStack gibi Remote sunucu hizmeti sunan firmaları kullanabiliriz.

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

Windows:
> https://docs.docker.com/docker-for-windows/install/

Mac : 
> https://docs.docker.com/docker-for-mac/install/


## Selenium Remote Test Projesi

- İntellij İdea ide indirilir.

> https://www.jetbrains.com/idea/download

- Proje indirilir.

> Code - Download Zip



## Selenium ve Zalenium İmage

```
1. $ Docker pull elgalu/selenium
2. $ Docker pull dosel/zalenium
```

 Başlatmak için aşağıdaki komutlar kullanılır.
 
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

indirilen Testi başlatalım. 
 
 Testi canlı izlemek için,
 >  Localhost:4444/grid/admin/live

 Test Sonuçları için,
> localhost:4444/dashboard
  
 
 **FIRAT ÇELİK ~ TEST AUTOMATİON ENGİNEER**
