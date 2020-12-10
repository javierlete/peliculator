SELECT *
FROM peliculas p, generos g
WHERE p.id_genero = g.id 
	AND p.id = 1;

SELECT *
FROM peliculas p
JOIN generos g ON p.id_genero = g.id
WHERE p.id = 1;


