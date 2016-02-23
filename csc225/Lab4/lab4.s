	.file	"lab4.c"
	.comm	pool1,12,4
	.comm	queue,8,4
	.comm	poolarea,1280,32
	.text
.globl initpool
	.type	initpool, @function
initpool:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$16, %esp
	movl	8(%ebp), %eax
	movl	$poolarea, (%eax)
	movl	8(%ebp), %eax
	movl	(%eax), %eax
	movl	%eax, -12(%ebp)
	movl	$19, -4(%ebp)
	jmp	.L2
.L3:
	movl	-12(%ebp), %eax
	addl	$64, %eax
	movl	%eax, -8(%ebp)
	movl	-8(%ebp), %edx
	movl	-12(%ebp), %eax
	movl	%edx, (%eax)
	movl	-8(%ebp), %eax
	movl	%eax, -12(%ebp)
	subl	$1, -4(%ebp)
.L2:
	cmpl	$0, -4(%ebp)
	jg	.L3
	movl	-12(%ebp), %eax
	movl	$0, (%eax)
	leave
	ret
	.size	initpool, .-initpool
.globl getbuffer
	.type	getbuffer, @function
getbuffer:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$16, %esp
	movl	8(%ebp), %eax
	movl	(%eax), %eax
	movl	%eax, -4(%ebp)
	cmpl	$0, -4(%ebp)
	je	.L6
	movl	-4(%ebp), %eax
	movl	(%eax), %eax
	movl	%eax, %edx
	movl	8(%ebp), %eax
	movl	%edx, (%eax)
	movl	-4(%ebp), %eax
	jmp	.L7
.L6:
	movl	$0, %eax
.L7:
	leave
	ret
	.size	getbuffer, .-getbuffer
.globl freebuffer
	.type	freebuffer, @function
freebuffer:
	pushl	%ebp
	movl	%esp, %ebp
	movl	8(%ebp), %eax
	movl	(%eax), %eax
	movl	%eax, %edx
	movl	12(%ebp), %eax
	movl	%edx, (%eax)
	movl	8(%ebp), %eax
	movl	12(%ebp), %edx
	movl	%edx, (%eax)
	popl	%ebp
	ret
	.size	freebuffer, .-freebuffer
.globl enqueue
	.type	enqueue, @function
enqueue:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$16, %esp
	movl	8(%ebp), %eax
	movl	(%eax), %eax
	testl	%eax, %eax
	jne	.L12
	movl	8(%ebp), %eax
	movl	12(%ebp), %edx
	movl	%edx, (%eax)
	jmp	.L13
.L12:
	movl	8(%ebp), %eax
	movl	4(%eax), %eax
	movl	%eax, -4(%ebp)
	movl	-4(%ebp), %eax
	movl	12(%ebp), %edx
	movl	%edx, (%eax)
.L13:
	movl	8(%ebp), %eax
	movl	12(%ebp), %edx
	movl	%edx, 4(%eax)
	movl	12(%ebp), %eax
	movl	$0, (%eax)
	leave
	ret
	.size	enqueue, .-enqueue
.globl dequeue
	.type	dequeue, @function
dequeue:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$16, %esp
	movl	8(%ebp), %eax
	movl	(%eax), %eax
	testl	%eax, %eax
	je	.L16
	movl	8(%ebp), %eax
	movl	(%eax), %eax
	movl	%eax, -4(%ebp)
	movl	-4(%ebp), %eax
	movl	(%eax), %eax
	movl	%eax, %edx
	movl	8(%ebp), %eax
	movl	%edx, (%eax)
	movl	-4(%ebp), %eax
	jmp	.L17
.L16:
	movl	$0, %eax
.L17:
	leave
	ret
	.size	dequeue, .-dequeue
	.section	.rodata
	.align 4
.LC0:
	.string	"Initializing a pool of LC3 buffers ..."
.LC1:
	.string	"Ok, pool initialized."
.LC2:
	.string	"About to get a buffer."
	.align 4
.LC3:
	.string	"Got buffer, it's pointer is: %p\n"
.LC4:
	.string	"Buffer added ok to queue."
.LC5:
	.string	"Sorry ... getbuffer failed."
	.align 4
.LC6:
	.string	"Got a buffer from the queue, it's pointer is: %p\n"
	.align 4
.LC7:
	.string	"Releasing the buffer back to the pool."
	.align 4
.LC8:
	.string	"oh my, no buffer on the queue. Sorry."
.LC9:
	.string	"Got 1st buffer, pointer=%p\n"
.LC10:
	.string	"Got another free buffer, %p\n"
	.align 4
.LC11:
	.string	"Storing object, bp1=%p, payloadp=%p\n"
.LC12:
	.string	"One small step for man."
.LC13:
	.string	"Placing it on the queue ..."
.LC14:
	.string	"Getting one more ..."
.LC15:
	.string	"One giant step for mankind."
.LC16:
	.string	"Dequeued one. pointer %p\n"
.LC17:
	.string	"Buffer payload: %s\n"
.LC18:
	.string	"Hey, we're done here!\n"
	.text
.globl main
	.type	main, @function
main:
	pushl	%ebp
	movl	%esp, %ebp
	andl	$-16, %esp
	subl	$32, %esp
	movl	$.LC0, (%esp)
	call	puts
	movl	$pool1, (%esp)
	call	initpool
	movl	$.LC1, (%esp)
	call	puts
	movl	$0, queue
	movl	$0, queue+4
	movl	$.LC2, (%esp)
	call	puts
	movl	$pool1, (%esp)
	call	getbuffer
	movl	%eax, 16(%esp)
	cmpl	$0, 16(%esp)
	je	.L20
	movl	$.LC3, %eax
	movl	16(%esp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	16(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$queue, (%esp)
	call	enqueue
	movl	$.LC4, (%esp)
	call	puts
	movl	$queue, (%esp)
	call	dequeue
	movl	%eax, 24(%esp)
	cmpl	$0, 24(%esp)
	jne	.L21
	jmp	.L27
.L20:
	movl	$.LC5, (%esp)
	call	puts
	movl	$1, (%esp)
	call	exit
.L21:
	movl	$.LC6, %eax
	movl	24(%esp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	$.LC7, (%esp)
	call	puts
	movl	24(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$pool1, (%esp)
	call	freebuffer
	jmp	.L23
.L27:
	movl	$.LC8, (%esp)
	call	puts
.L23:
	movl	$pool1, (%esp)
	call	getbuffer
	movl	%eax, 20(%esp)
	movl	$.LC9, %eax
	movl	20(%esp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	$.LC10, %eax
	movl	20(%esp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	20(%esp), %eax
	addl	$4, %eax
	movl	%eax, 28(%esp)
	movl	$.LC11, %eax
	movl	28(%esp), %edx
	movl	%edx, 8(%esp)
	movl	20(%esp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	$.LC12, %eax
	movl	$24, 8(%esp)
	movl	%eax, 4(%esp)
	movl	28(%esp), %eax
	movl	%eax, (%esp)
	call	memcpy
	movl	$.LC13, (%esp)
	call	puts
	movl	20(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$queue, (%esp)
	call	enqueue
	movl	$.LC14, (%esp)
	call	puts
	movl	$pool1, (%esp)
	call	getbuffer
	movl	%eax, 20(%esp)
	movl	20(%esp), %eax
	addl	$4, %eax
	movl	%eax, 28(%esp)
	movl	$.LC11, %eax
	movl	28(%esp), %edx
	movl	%edx, 8(%esp)
	movl	20(%esp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	$.LC15, %eax
	movl	$28, 8(%esp)
	movl	%eax, 4(%esp)
	movl	28(%esp), %eax
	movl	%eax, (%esp)
	call	memcpy
	movl	20(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$queue, (%esp)
	call	enqueue
	jmp	.L24
.L25:
	movl	$.LC16, %eax
	movl	24(%esp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	24(%esp), %eax
	addl	$4, %eax
	movl	%eax, 28(%esp)
	movl	$.LC17, %eax
	movl	28(%esp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	printf
	movl	24(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$pool1, (%esp)
	call	freebuffer
.L24:
	movl	$queue, (%esp)
	call	dequeue
	movl	%eax, 24(%esp)
	cmpl	$0, 24(%esp)
	jne	.L25
	movl	$.LC18, (%esp)
	call	puts
	leave
	ret
	.size	main, .-main
	.ident	"GCC: (GNU) 4.4.7 20120313 (Red Hat 4.4.7-4)"
	.section	.note.GNU-stack,"",@progbits
