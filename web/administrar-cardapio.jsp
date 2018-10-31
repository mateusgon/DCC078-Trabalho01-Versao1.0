<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<div class="container text-center">
    <h1> Meu Restaurante </h1>
</div>
<div class="container text-center">
    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=CadastrarItem&id=${idRestaurante}" >
                        <h5 class="card-title"> Cadastar item </h5>
                        <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAIxSURBVGhD7dm9axRBHMbxE99QERFFbAL+AYqVL4UgdiKoRVBEG3tFsBAL/wKx8RW0UtRIiCBWIURsooK1YCW+F0KihIj4mhe/j97CMPu7vV0zdzuH88CHy83u7O3vbnZ3dtNI+Q+yDicxhnHM4Qde4g72YCGizQpcwU9o54u8x35Ely14BWuni9zEMtSSRVjw988/2YrPsHa0jFEsQZbFzdfg2YDTeIwPmMU0NDzuNV+tHaziAZ5gqvn+G15Dx9RBuIVWzlqUHfOd9haHUTmb8QbWRut0A0tRKpswnzHfacNoe/pegxh/Cd85FOYCrI6xmcFGmOmDrsBWxxjdhxlNK6wOsdLZdBVyeQirQ8x0jclF52pr5ZidQS69dHxkLiIXTQuslWN2Hrn0wvXDpzlgLndhrRyzXcjlKKyVYzUBc961HB9hdYrRWbTMMVidYqMvfDVaRrPKEVidY6Ebu71oG132n8LaSN1UxHGUjp6I3IK1sbp8Qj/+Kbuhe3Vrwy5dgya9toyerrS6UXuBL16b7ysuYz3mFQ016wMy+qb0cGCn05Z5Bx13+5y2zHPoacwhp80ygCBpV4gmm4pukf1lz6DsgL/sERRrmSsV4qfThVhD0tW1Qn5B05tLTlumqBCdAA5g0GmzdK2QIt9xBNedtqqiKCSEVIifVEggwQrRfcpQjU4gxY3+g6TzfV22IUjSwR5IKsRPKiSQVIiflbA+oFtuI1hO4VoNrmI7UnosjcZvjKq8ornk5lIAAAAASUVORK5CYII=">
                    </a>
                </div>
            </div>
        </div>
        <div class="col-sm-4" >
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=ListarItens&id=${idRestaurante}">
                        <h5 class="card-title"> Listar itens </h5>
                        <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAQySURBVGhD7ZlryE1ZGMdfQwbjGikl11ySa8olRFFynQ/CjFJuKeGTD3IrKZeEqEnRuJWEFB+IaZovRJGQS0KSW0m5NWFcx/+37ee033PW2Xud95z3fffR+devd69nrb32+5y9nrWetXZVRRVV5K3fxSXxUfxfJP+KU2KoQI3EUnFLfBKuewrhpTgouotq2iGs0RdBw5ryWlhf/NNzxV8RGz+U6z5f+JGsrzdiuAg0U2CkwXzRQhSr9mK9+CrsoQ/FRNFYFKtu4qig3yeimag6FxoWUiix9glzZAiGEqqhuCzoezaGd2GhLYUENRBNv196abyg7wdBqfRaIeh/GwUuIE4E62rxSnwWV8UkkaR+gr5567WhRYL+d1JIcoS3wAxh7ewNMv4J5DilypEFgvoXYrD4SSwROPKf6CnyKZ8jzUWbBFqLqFqKVt8vM/J2hCH1VFA/A0NE2wX2I0HJLZcjIwXD054bx0aBeLbZ1mAI5e3IVEHd3aBUXe0Ew4y1ogMGh1yO9BE3xf0E7gmWA8RacUdgm4UhlLcjuwR1G4JSrmwuZ/i5lJoYuS6oy6yeWSJWqP8zKOUqNY4QzNSxUrvESk392aCUq3yOMBRZnePoLJhYTB0FNmZRk5cjLHzY3wclt/oK2twISrlyOTJaRFOXOLYIRFyYbR2GUF6O8Gswu/BW8skcIWt2yeVID3FFuAI8CsFtgU0WzTC/LaZhCOU9tB4J6joFpVz9Kqg/FpRylZoY2S2oI83PFmP1tKA+X8KZGkd6iw+CesamBRqpuGW2mTTaoXyOMLzIEuLoL8hwTaw/9Be1eTuCGKe2Ei/DIO0XlNlE2S7QJZcjY4U9MwmyBzRHmI19jqkgRxABRhsC7hfBav5W9BJxcjnSVTBds5eI46KYLtAgcUFgm4IhVMGOkKzRhl0egW/XSUpNjJgqjgjaZjtC4LoCPArD6WeBmGQI/oEiuuevV0ds++vDHwLNE2bbjCFUvTrC/RwPuQI8CsHNNgINEP+I84IfwlSJkR/GkceiFI4ME+MSGCMsYyCBHSXInG0CQDV2hJXcHCFDTZLLkQnCnplE8A9K5HJms9QeFewIvwJt2JtY6s4qnySXI2yqToi/EzgjLLDJ+TgUJ0nlTZkKdgTZeZbtCn3GfepiBLF5ot3J8C8HE0lKpSMrhbWF1B6ZRjf1LrEPWC4Oi+D020N16sizsBB39FlT1bYjWwX9BwcSB8LCIRE9fimFatORLsK+jo3AwLaTT1gY2PAsFmxoioGFq4nIdoQ1aLJw3ePLb4I3wGc4+j4uMmJufi6oKBX0tym85txrr/A9z/KFGZRT+mpi9SZ49gjOdIuBqZqPqtkP5tMEC53rHl+YbPhCRRpTJ+ItR7/Akrrz3aMstUrgBIcV+c6Py0IcFeHItaBUxmIRXSvIzyqqqPxUVfUNHE+GHUyeZtcAAAAASUVORK5CYII=">
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container text-center">
    <div class="row" style="margin-top: 1.5cm">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=CadastrarItem&id=${idRestaurante}" >
                        <h5 class="card-title"> Cadastrar combo </h5>
                        <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAIxSURBVGhD7dm9axRBHMbxE99QERFFbAL+AYqVL4UgdiKoRVBEG3tFsBAL/wKx8RW0UtRIiCBWIURsooK1YCW+F0KihIj4mhe/j97CMPu7vV0zdzuH88CHy83u7O3vbnZ3dtNI+Q+yDicxhnHM4Qde4g72YCGizQpcwU9o54u8x35Ely14BWuni9zEMtSSRVjw988/2YrPsHa0jFEsQZbFzdfg2YDTeIwPmMU0NDzuNV+tHaziAZ5gqvn+G15Dx9RBuIVWzlqUHfOd9haHUTmb8QbWRut0A0tRKpswnzHfacNoe/pegxh/Cd85FOYCrI6xmcFGmOmDrsBWxxjdhxlNK6wOsdLZdBVyeQirQ8x0jclF52pr5ZidQS69dHxkLiIXTQuslWN2Hrn0wvXDpzlgLndhrRyzXcjlKKyVYzUBc961HB9hdYrRWbTMMVidYqMvfDVaRrPKEVidY6Ebu71oG132n8LaSN1UxHGUjp6I3IK1sbp8Qj/+Kbuhe3Vrwy5dgya9toyerrS6UXuBL16b7ysuYz3mFQ016wMy+qb0cGCn05Z5Bx13+5y2zHPoacwhp80ygCBpV4gmm4pukf1lz6DsgL/sERRrmSsV4qfThVhD0tW1Qn5B05tLTlumqBCdAA5g0GmzdK2QIt9xBNedtqqiKCSEVIifVEggwQrRfcpQjU4gxY3+g6TzfV22IUjSwR5IKsRPKiSQVIiflbA+oFtuI1hO4VoNrmI7UnosjcZvjKq8ornk5lIAAAAASUVORK5CYII=">
                    </a>
                </div>
            </div>
        </div>
        <div class="col-sm-4" >
            <div class="card">
                <div class="card-body">
                    <a href="FrontController?action=ListarItens&id=${idRestaurante}">
                        <h5 class="card-title"> Listar combos </h5>
                        <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAQySURBVGhD7ZlryE1ZGMdfQwbjGikl11ySa8olRFFynQ/CjFJuKeGTD3IrKZeEqEnRuJWEFB+IaZovRJGQS0KSW0m5NWFcx/+37ee033PW2Xud95z3fffR+devd69nrb32+5y9nrWetXZVRRVV5K3fxSXxUfxfJP+KU2KoQI3EUnFLfBKuewrhpTgouotq2iGs0RdBw5ryWlhf/NNzxV8RGz+U6z5f+JGsrzdiuAg0U2CkwXzRQhSr9mK9+CrsoQ/FRNFYFKtu4qig3yeimag6FxoWUiix9glzZAiGEqqhuCzoezaGd2GhLYUENRBNv196abyg7wdBqfRaIeh/GwUuIE4E62rxSnwWV8UkkaR+gr5567WhRYL+d1JIcoS3wAxh7ewNMv4J5DilypEFgvoXYrD4SSwROPKf6CnyKZ8jzUWbBFqLqFqKVt8vM/J2hCH1VFA/A0NE2wX2I0HJLZcjIwXD054bx0aBeLbZ1mAI5e3IVEHd3aBUXe0Ew4y1ogMGh1yO9BE3xf0E7gmWA8RacUdgm4UhlLcjuwR1G4JSrmwuZ/i5lJoYuS6oy6yeWSJWqP8zKOUqNY4QzNSxUrvESk392aCUq3yOMBRZnePoLJhYTB0FNmZRk5cjLHzY3wclt/oK2twISrlyOTJaRFOXOLYIRFyYbR2GUF6O8Gswu/BW8skcIWt2yeVID3FFuAI8CsFtgU0WzTC/LaZhCOU9tB4J6joFpVz9Kqg/FpRylZoY2S2oI83PFmP1tKA+X8KZGkd6iw+CesamBRqpuGW2mTTaoXyOMLzIEuLoL8hwTaw/9Be1eTuCGKe2Ei/DIO0XlNlE2S7QJZcjY4U9MwmyBzRHmI19jqkgRxABRhsC7hfBav5W9BJxcjnSVTBds5eI46KYLtAgcUFgm4IhVMGOkKzRhl0egW/XSUpNjJgqjgjaZjtC4LoCPArD6WeBmGQI/oEiuuevV0ds++vDHwLNE2bbjCFUvTrC/RwPuQI8CsHNNgINEP+I84IfwlSJkR/GkceiFI4ME+MSGCMsYyCBHSXInG0CQDV2hJXcHCFDTZLLkQnCnplE8A9K5HJms9QeFewIvwJt2JtY6s4qnySXI2yqToi/EzgjLLDJ+TgUJ0nlTZkKdgTZeZbtCn3GfepiBLF5ot3J8C8HE0lKpSMrhbWF1B6ZRjf1LrEPWC4Oi+D020N16sizsBB39FlT1bYjWwX9BwcSB8LCIRE9fimFatORLsK+jo3AwLaTT1gY2PAsFmxoioGFq4nIdoQ1aLJw3ePLb4I3wGc4+j4uMmJufi6oKBX0tym85txrr/A9z/KFGZRT+mpi9SZ49gjOdIuBqZqPqtkP5tMEC53rHl+YbPhCRRpTJ+ItR7/Akrrz3aMstUrgBIcV+c6Py0IcFeHItaBUxmIRXSvIzyqqqPxUVfUNHE+GHUyeZtcAAAAASUVORK5CYII=">
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="jspf/rodape.jspf" %>