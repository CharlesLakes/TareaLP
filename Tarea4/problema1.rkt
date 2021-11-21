#lang scheme


;;(mazo cartas divisor)
;;Esta funcion obtiene una lista de las cartas multipos de el divisor
;;Retorna los numeros multiplos de el divisor

;;Problema 1
(define mazo
	(lambda (cartas divisor)
		(let mazo-loop ((lista cartas) (new_lista '()))
		 	(if (null? lista)
			    	new_lista
				(if (= (modulo (car lista) divisor) 0)
					(mazo-loop (cdr lista) (append new_lista (list (car lista))))
			    		(mazo-loop (cdr lista) new_lista) 
				)
			 )
		 )
	) 
)

(mazo '(1 2 3 4 5) 2)
