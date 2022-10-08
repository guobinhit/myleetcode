package easy_collection

import "testing"

func Test_isPalindrome125(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "isPalindrome125 true",
			args: args{s: "A man, a plan, a canal: Panama"},
			want: true,
		},
		{
			name: "isPalindrome125 false",
			args: args{s: ".,"},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isPalindrome125(tt.args.s); got != tt.want {
				t.Errorf("isPalindrome125() = %v, want %v", got, tt.want)
			}
		})
	}
}
