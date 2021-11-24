#lang scheme

;;(in-list n lista)
;;Verifica si un numero se encuentra en una lista
;;Devuelve 1 si se encuentra y 0 si no se encuentra
(define in-list (lambda (n lista)
		(if (null? lista)
			0
			(if (= n (car lista))
				1
				(in-list n (cdr lista))
			 )
		 )
	    )
  )

;;(unit lista-uno lista-dos)
;;Une dos listas sin repetir numeros
;;Devuelve la lista sin repeticiones
(define unir (lambda (lista-uno lista-dos)
			(let loop-unir ((lista lista-dos) (lista-resultante lista-uno))
				(if (null? lista)
					lista-resultante
					(if (= (in-list (car lista) lista-resultante) 1)
					    	(loop-unir (cdr lista) lista-resultante)
						(loop-unir (cdr lista) (append lista-resultante (list (car lista))))
					 )
				 )
		 	)
	      )

 )

;;(buscar-nodo grafo n)
;;Busca el nodo n con sus vecinos respectivos
;;Devuelve el nodo n
(define buscar-nodo (lambda (grafo n) (if (= (car (car grafo)) n) (car grafo) (buscar-nodo (cdr grafo) n))))

;;(contagio grafo n d)
;;Obtiene los nodos contagiados segun unos dias determinados
;;Devuelve los nodos contagiados
;;Problema 5
(define contagio (lambda (grafo n d)
			(let loop-contagio ((dias 0) (contagiados (list n)) (temp-contagiados '()) (vecinos '()))
				(if (= dias d)
					contagiados
					(if (null? contagiados)
						(loop-contagio (+ dias 1) (unir temp-contagiados vecinos) '() '())
						(loop-contagio dias (cdr contagiados) (append temp-contagiados (list (car contagiados))) (unir vecinos (cadr (buscar-nodo grafo (car contagiados)))))
					 )
				 )
			 )
		  )

 )


(contagio '((2 (1 3 4)) (1 (2)) (3 (2)) (4 (2 5)) (5 ())) 2 22)

