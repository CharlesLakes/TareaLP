#lang scheme

(define obtener-nodo-n (lambda (grafo n) 
			(if (or (null? grafo) (= n (car (car grafo)))) (car grafo) (obtener-nodo-n (cdr grafo) n))
		)
  )

(define contagio (lambda (grafo n d) 
		   1
		)
  )

(obtener-nodo-n  '((2 (1 3 4)) (1 (2)) (3 (2)) (4 (2))) 1)
