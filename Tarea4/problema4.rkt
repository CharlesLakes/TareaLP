#lang scheme

(define vida 
	(lambda (h arbol)
		(let loop-arbol ((nodo (car arbol)) (arbol-izquierdo (cadr arbol)) (arbol-derecho (caddr arbol)) (lista-nodos '()))
		  	(cond
			  	[(= h nodo) lista-nodos]
			 	[(and (not (null? arbol-izquierdo)) (not (null? (loop-arbol (car arbol-izquierdo) (cadr arbol-izquierdo) (caddr arbol-izquierdo) (append lista-nodos (list nodo))))))
				 (loop-arbol (car arbol-izquierdo) (cadr arbol-izquierdo) (caddr arbol-izquierdo) (append lista-nodos (list nodo)))]
				[(and (not (null? arbol-izquierdo)) (not (null? (loop-arbol (car arbol-derecho) (cadr arbol-derecho) (caddr arbol-derecho) (append lista-nodos (list nodo)))))) 
				 (loop-arbol (car arbol-derecho) (cadr arbol-derecho) (caddr arbol-derecho) (append lista-nodos (list nodo)))]
				[else '()]


			 )
		  )

	 )

 )


(vida 4 '(5 (3 (2 () ()) (4 () ())) (8 (6 () ()) ())))

