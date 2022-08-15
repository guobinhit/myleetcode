package easy_collection

import (
	"github.com/guobinhit/sylph/common/utils"
	"reflect"
	"testing"
)

func Test_generate(t *testing.T) {
	type args struct {
		numRows int
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "generate",
			args: args{numRows: 5},
			want: `[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]`,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got := generate(tt.args.numRows)
			if !reflect.DeepEqual(utils.Json(got), tt.want) {
				t.Errorf("generate() = %v, want %v", utils.Json(got), tt.want)
			}
		})
	}
}
