 $(function() {

            $("#jc").click(function() {
                $("#cpjccp").show();
                $("#cpzhcx").hide();
                $("#cpgdxc").hide();
                $("#cpwgcp").hide();
                $("#cphb").hide();
                $("#cpsc").hide();
            });

            $("#cx").click(function() {
                $("#cpzhcx").show();
                $("#cpjccp").hide();
                $("#cpgdxc").hide();
                $("#cpwgcp").hide();
                $("#cphb").hide();
                $("#cpsc").hide();
            });

            $("#xc").click(function() {
                $("#cpjccp").hide();
                $("#cpzhcx").hide();
                $("#cpgdxc").show();
                $("#cpwgcp").hide();
                $("#cphb").hide();
                $("#cpsc").hide();
            });

            $("#wp").click(function() {
                $("#cpjccp").hide();
                $("#cpzhcx").hide();
                $("#cpgdxc").hide();
                $("#cpwgcp").show();
                $("#cphb").hide();
                $("#cpsc").hide();
            });

            $("#hbei").click(function() {
                $("#cpjccp").hide();
                $("#cpzhcx").hide();
                $("#cpgdxc").hide();
                $("#cpwgcp").hide();
                $("#cphb").show();
                $("#cpsc").hide();
            });

            $("#scai").click(function() {
                $("#cpjccp").hide();
                $("#cpzhcx").hide();
                $("#cpgdxc").hide();
                $("#cpwgcp").hide();
                $("#cphb").hide();
                $("#cpsc").show();
            });

        });