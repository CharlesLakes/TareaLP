#lang scheme

;;(zeta_simple i s)
;;Calcula la zeta simple
;;Retorna la sumatoria desde el inicio

;;Problema 3
(define zeta_simple
	(lambda (i s) 
		(if (= i 1) 1 (+ (zeta_simple (- i 1) s) (/ 1 (expt i s))))
))

;;(zeta_cola i s)
;;Calcula la zeta cola
;;Retorna la sumatoria desde la cola

;;Problema 3
(define zeta_cola
        (lambda (i s)
                (let loop-zeta-cola ((n i) (r 0))
                        (if (= n 0)
                                r
                                (loop-zeta-cola (- n 1) (+ r (/ 1 (expt n s))))

                        )
                )
))

(zeta_simple 3 2)
(zeta_cola 3 2)
