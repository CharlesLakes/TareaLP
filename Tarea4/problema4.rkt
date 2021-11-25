#lang scheme

;;(vida h arbol)
;;Esta funcion encuentra los padres de un nodo
;;Retorna los nodos padres a h

;;Problema 4
(define vida 
	(lambda (h arbol)
		(if (null? arbol) arbol
			(let loop-arbol ((a arbol) (nodo (car arbol)) (arbol-izquierdo (cadr arbol)) (arbol-derecho (caddr arbol)) (lista-nodos '()))
				(cond
					[(= h nodo) lista-nodos]
					[(null? a) '()]
					[(and (not (null? arbol-izquierdo)) (not (null? (loop-arbol arbol-izquierdo (car arbol-izquierdo) (cadr arbol-izquierdo) (caddr arbol-izquierdo) (append lista-nodos (list nodo))))))
						(loop-arbol arbol-izquierdo (car arbol-izquierdo) (cadr arbol-izquierdo) (caddr arbol-izquierdo) (append lista-nodos (list nodo)))]
					[(and (not (null? arbol-derecho)) (not (null? (loop-arbol arbol-derecho (car arbol-derecho) (cadr arbol-derecho) (caddr arbol-derecho) (append lista-nodos (list nodo)))))) 
						(loop-arbol arbol-derecho (car arbol-derecho) (cadr arbol-derecho) (caddr arbol-derecho) (append lista-nodos (list nodo)))]
					[else '()]
				)
			)
		)

	)

)

(vida 4 '(5 (3 (2 () ()) (4 () ())) (8 (6 () ()) ())))
