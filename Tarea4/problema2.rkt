#lang scheme

;;(transformacion funcion1 funcion2 numeros)
;;La funcion ejecuta en cada numero de numero la funcion1 y la funcion2 quedando r1,  para obtener r2 es ejecutando la funcion2 y luego la funcion1. En la lista resultante se queda el mayor
;;Retonra los resutlados segun cada numero de la lista

;;Problema 2
(define transformacion
	(lambda (funcion1 funcion2 numeros)
		(let loop-trans ((lista_inicial numeros) (lista_final '()))
			(if (null? lista_inicial) 
			 	lista_final
				(if (> (funcion1 (funcion2 (car lista_inicial))) (funcion2 (funcion1 (car lista_inicial))))
				    (loop-trans (cdr lista_inicial) (append lista_final (list (funcion1 (funcion2 (car lista_inicial))))))
				    (loop-trans (cdr lista_inicial) (append lista_final (list (funcion2 (funcion1 (car lista_inicial))))))
				 )
			)		  	
		  )
	  )

 )


(transformacion (lambda (x) (+ 2 x)) (lambda (x) (/ x 2)) '(2 3 4))

