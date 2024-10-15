$(document).ready(function(){
    function refreshPersonList(){
        $.get("/Person/get", function(data){
            console.log(data);

            data.forEach(function(person){
                $("#personList      ").append(
                    `<tr>
                        <td>${person.id}</td>
                        <td>${person.firstName}</td>
                        <td>${person.lastName}</td>
                        <td>${person.weight}</td>
                        <td>${person.height}</td>
                    </tr>
                    `

                );
            });
        });
    }


    $("#addPersonForm").on("submit", function(event) {
        event.preventDefault(); // Prevent form submission

        const personData = {
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            weight: parseFloat($("#weight").val()),
            height: parseFloat($("#height").val())
        };

        $.ajax({
            type: "POST",
            url: "/Person/add",
            contentType: "application/json",
            data: JSON.stringify(personData),
            success: function(response) {
                console.log(response);
                refreshPersonList(); // Refresh the list after adding
            },
            error: function(xhr, status, error) {
                console.error("Error adding person: ", error);
            }
        });
    });

    
    refreshPersonList();
});