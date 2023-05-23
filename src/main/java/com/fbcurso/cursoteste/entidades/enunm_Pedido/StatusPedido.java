package com.fbcurso.cursoteste.entidades.enunm_Pedido;



public enum StatusPedido {
    AGUARDANDO_PAGAMENTO(1),   //WATTING_PAYMENT
    PAGO(2),                   //PAID
    ENVIADO(3),                //SHIPPED
    ENTREGUE(4),               //DELIVERED
    CANCELADO(5);              //CANCELED

    private int code;

    private StatusPedido(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }
    public static StatusPedido valueOf(int code){
        for(StatusPedido value : StatusPedido.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Status codigo pedido invalido");
        }
}
