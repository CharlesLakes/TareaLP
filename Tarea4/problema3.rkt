#lang scheme

;;(elevar numero exponente)
;;Eleva un numero al exponente seleccionado
;;Devuelve el numero elevado
(define elevar
	(lambda (numero exponente)
	 (if (= exponente 0) 1 (* numero (elevar numero (- exponente 1))))
	)
 )

;;(zeta_simple i s)
;;Calcula la zeta simple
;;Problema 3
(define zeta_simple
	(lambda (i s) 
		(let loop-zeta-simple ((n 1) (r 0))
			(if (= n (+ i 1))
		    		r
		    		(loop-zeta-simple (+ n 1) (+ r (/ 1 (elevar n s))))
		 	)
		)
))

;;(zeta_cola i s)
;;Calcula la zeta cola
;;Problema 3
(define zeta_cola
        (lambda (i s)
                (let loop-zeta-cola ((n i) (r 0))
                        (if (= n 0)
                                r
                                (loop-zeta-cola (- n 1) (+ r (/ 1 (elevar n s))))

                        )
                )
))

(zeta_simple 3 2)
(zeta_cola 3 2)
