# Organizacion de Lenguajes y compiladores 1
## Proyecto 1 Data Forge
### Primer semestre 2024
```js
Universidad San Carlos de Guatemala
Programador: Joel Alexander Guzaro Tzunun
Carne: 202201395
```
```
<inicio> ::= PRGRM <instructions_list> ENDPRGRM

<instructions_list> ::= <instructions_list> instruction 
            | <instruction>

<instruction> ::= <varasigdouble>
            | <varasigchar>
            | <varasigarr>
            | <ins_cnsl>
            | <ins_clmn>
            | <exps_grph_bar>
            | <exps_grph_pie>
            | <exps_grph_ln>
            | <exps_grph_hst>
            | error SMCLN

<varasigdouble> ::= VRBL DPOINTS TYPED DPOINTS DPOINTS NAMEVAR LARROW SMINUS <exps_nmbr> END SMCLN 

<varasigchar> ::= VRBL DPOINTS TYPEC DPOINTS DPOINTS NAMEVAR LARROW SMINUS <exps_chr> END SMCLN 

<varasigarr> ::= ARR DPOINTS TYPED DPOINTS DPOINTS SAT NAMEVAR LARROW SMINUS LSBRCKT <exps_arrd> RSBRCKT END SMCLN
                | ARR DPOINTS TYPEC DPOINTS DPOINTS SAT NAMEVAR LARROW SMINUS LSBRCKT <exps_arrc> RSBRCKT END SMCLN 

<exps_nmbr> ::= NMBR
            | <math_op>
            | NAMEVAR
;

<exps_chr> ::= STRNG
            | NAMEVAR

<exps_arrd> ::= <exps_nmbr>
            | <exps_arrd> CMM <exps_nmbr>

<exps_arrc> ::= <exps_chr>
            |  <exps_arrc> CMM <exps_chr>

<exps_est> ::= SAT NAMEVAR
            | LSBRCKT <exps_arrd> RSBRCKT

<exps_var_clmn> ::= NMBR
            | STRNG
            | NAMEVAR

<exps_array_clmn> ::= <exps_var_clmn>
            | <exps_array_clmn> CMM <exps_var_clmn>

<math_op> ::= <ins_op>
            | <ins_est>


<ins_op> ::= WSUM LSPRTH <exps_nmbr> CMM <exps_nmbr> RSPRTH
            | WRES LSPRTH <exps_nmbr> CMM <exps_nmbr> RSPRTH
            | WMUL LSPRTH <exps_nmbr> CMM <exps_nmbr> RSPRTH
            | WDIV LSPRTH <exps_nmbr> CMM <exps_nmbr> RSPRTH
            | WMOD LSPRTH <exps_nmbr> CMM <exps_nmbr> RSPRTH


<ins_est> ::= WMED LSPRTH <exps_est>RSPRTH
            | WMEDN LSPRTH <exps_est> RSPRTH
            | WMDA LSPRTH <exps_est> RSPRTH
            | WVRNZ LSPRTH <exps_est> RSPRTH
            | WMX LSPRTH <exps_est> RSPRTH
            | WMN LSPRTH <exps_est> RSPRTH


<ins_cnsl> ::= CNSL DPOINTS DPOINTS PRNT SEQLS <exps_prnt> END SMCLN

<exps_prnt> ::= <exps_nmbr>
            | STRNG
            | <exps_prnt> CMM <exps_nmbr>
            | <exps_prnt> CMM STRNG

<ins_clmn> ::= CNSL DPOINTS DPOINTS CLMN SEQLS <exps_chr> SMINUS RArrow <exps_arrc>_clmn END SMCLN

<exps_clmn> ::= <exps_est>
            | <exps_arrc>_clmn
;

<exps_arrc>_clmn ::= SAT NAMEVAR
            | LSBRCKT <exps_array_clmn> RSBRCKT


<exps_grph_bar> ::= GBAR LSPRTH <data_grph_bar> EXEC GBAR END SMCLN RSPRTH END SMCLN


<exps_grph_pie> ::= GPIE LSPRTH <data_grph_pie> EXEC GPIE END SMCLN RSPRTH END SMCLN


<exps_grph_ln> ::= GLINE LSPRTH <data_grph_ln> EXEC GLINE END SMCLN RSPRTH END SMCLN

<exps_grph_hst> ::= HSTGRM LSPRTH <data_grph_hst> EXEC HSTGRM END SMCLN RSPRTH END SMCLN

<exps_grph_ch> ::= SAT NAMEVAR
            | LSBRCKT <exps_arrc> RSBRCKT

<ins_grph_bar> ::= <varasigtitle>
            | <varasigaxisX>
            | <varasigaxisY>
            | <varasigtitle>X
            | <varasigtitle>Y

<ins_grph_pie> ::= <varasigtitle>
            | <varasiglabel>
            | <varasigvalues>

<ins_grph_hst> ::= <varasigtitle>
            | <varasigvalues>

<data_grph_bar> ::= <data_grph_bar> <ins_grph_bar>
            | <ins_grph_bar>

<data_grph_pie> ::= <data_grph_pie> <ins_grph_pie>
            | <ins_grph_pie>

<data_grph_ln> ::= <data_grph_ln> <ins_grph_bar>
            | <ins_grph_bar>

<data_grph_hst> ::= <data_grph_hst> <ins_grph_hst>
            | <ins_grph_hst>


<varasigtitle> ::= TTL DPOINTS DPOINTS TYPEC SEQLS <exps_chr> END SMCLN

<varasigaxisX> ::= AXISX DPOINTS DPOINTS TYPEC SEQLS <exps_grph_ch> END SMCLN

<varasigaxisY> ::= AXISY DPOINTS DPOINTS TYPED SEQLS <exps_est> END SMCLN

<varasigtitle>X ::= TTLX DPOINTS DPOINTS TYPEC SEQLS <exps_chr> END SMCLN

<varasigtitle>Y ::= TTLY DPOINTS DPOINTS TYPEC SEQLS <exps_chr> END SMCLN

<varasiglabel> ::= LBL DPOINTS DPOINTS TYPEC SEQLS <exps_grph_ch> END SMCLN

<varasigvalues> ::= VLS DPOINTS DPOINTS TYPED SEQLS <exps_est> END SMCLN
```
