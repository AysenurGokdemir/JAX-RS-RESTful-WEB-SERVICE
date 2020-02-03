select * from musteri,vale_firmalari,rezervasyon 
where musteri.musteriId=vale_firmalari.firmaId 
and rezervasyon.firmaId=vale_firmalari.firmaId;